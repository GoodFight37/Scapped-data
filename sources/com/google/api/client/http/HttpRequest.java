package com.google.api.client.http;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.opencensus.common.Scope;
import io.opencensus.contrib.http.util.HttpTraceAttributeConstants;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX;
    public static final String VERSION;

    @Deprecated
    private BackOffPolicy backOffPolicy;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;
    private HttpIOExceptionHandler ioExceptionHandler;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int readTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int writeTimeout = 0;
    private boolean followRedirects = true;
    private boolean useRawRedirectUrls = false;
    private boolean throwExceptionOnExecuteError = true;

    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;
    private final Tracer tracer = OpenCensusUtils.getTracer();
    private boolean responseReturnRawInputStream = false;

    static {
        String version = getVersion();
        VERSION = version;
        USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/" + version + " (gzip)";
    }

    HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.backOffPolicy = backOffPolicy;
        return this;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public HttpRequest setWriteTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.writeTimeout = i;
        return this;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public boolean getUseRawRedirectUrls() {
        return this.useRawRedirectUrls;
    }

    public HttpRequest setUseRawRedirectUrls(boolean z) {
        this.useRawRedirectUrls = z;
        return this;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    public boolean getResponseReturnRawInputStream() {
        return this.responseReturnRawInputStream;
    }

    public HttpRequest setResponseReturnRawInputStream(boolean z) {
        this.responseReturnRawInputStream = z;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x02c2 A[Catch: all -> 0x0307, TryCatch #4 {all -> 0x0307, blocks: (B:114:0x02bc, B:116:0x02c2, B:118:0x02c6, B:121:0x02ce, B:125:0x02e0, B:127:0x02e4, B:129:0x02ee, B:132:0x02fa, B:136:0x0303), top: B:178:0x02bc }] */
    /* JADX WARN: Code duplicated, block: B:118:0x02c6 A[Catch: all -> 0x0307, TryCatch #4 {all -> 0x0307, blocks: (B:114:0x02bc, B:116:0x02c2, B:118:0x02c6, B:121:0x02ce, B:125:0x02e0, B:127:0x02e4, B:129:0x02ee, B:132:0x02fa, B:136:0x0303), top: B:178:0x02bc }] */
    /* JADX WARN: Code duplicated, block: B:119:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:121:0x02ce A[Catch: all -> 0x0307, TryCatch #4 {all -> 0x0307, blocks: (B:114:0x02bc, B:116:0x02c2, B:118:0x02c6, B:121:0x02ce, B:125:0x02e0, B:127:0x02e4, B:129:0x02ee, B:132:0x02fa, B:136:0x0303), top: B:178:0x02bc }] */
    /* JADX WARN: Code duplicated, block: B:123:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:124:0x02de  */
    /* JADX WARN: Code duplicated, block: B:136:0x0303 A[Catch: all -> 0x0307, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0307, blocks: (B:114:0x02bc, B:116:0x02c2, B:118:0x02c6, B:121:0x02ce, B:125:0x02e0, B:127:0x02e4, B:129:0x02ee, B:132:0x02fa, B:136:0x0303), top: B:178:0x02bc }] */
    /* JADX WARN: Code duplicated, block: B:142:0x030e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0310  */
    /* JADX WARN: Code duplicated, block: B:144:0x0312  */
    /* JADX WARN: Code duplicated, block: B:150:0x031b  */
    /* JADX WARN: Code duplicated, block: B:153:0x032c  */
    /* JADX WARN: Code duplicated, block: B:155:0x0330  */
    /* JADX WARN: Code duplicated, block: B:167:0x034a  */
    /* JADX WARN: Code duplicated, block: B:168:0x034b A[LOOP:0: B:10:0x0035->B:168:0x034b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:178:0x02bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x02fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:38:0x0129  */
    /* JADX WARN: Code duplicated, block: B:45:0x013b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0140  */
    /* JADX WARN: Code duplicated, block: B:50:0x0148  */
    /* JADX WARN: Code duplicated, block: B:51:0x0157  */
    /* JADX WARN: Code duplicated, block: B:54:0x015d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0166  */
    /* JADX WARN: Code duplicated, block: B:57:0x0176  */
    /* JADX WARN: Code duplicated, block: B:59:0x017a  */
    /* JADX WARN: Code duplicated, block: B:61:0x0198  */
    /* JADX WARN: Code duplicated, block: B:62:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:70:0x0200  */
    /* JADX WARN: Code duplicated, block: B:72:0x0206  */
    /* JADX WARN: Code duplicated, block: B:74:0x0218  */
    /* JADX WARN: Code duplicated, block: B:76:0x0220  */
    /* JADX WARN: Code duplicated, block: B:78:0x0229  */
    /* JADX WARN: Code duplicated, block: B:80:0x023c  */
    /* JADX WARN: Code duplicated, block: B:85:0x024e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0272 A[Catch: all -> 0x0290, IOException -> 0x0293, TRY_LEAVE, TryCatch #3 {IOException -> 0x0293, blocks: (B:87:0x026c, B:89:0x0272, B:93:0x0286, B:95:0x028c, B:96:0x028f), top: B:172:0x026c, outer: #0 }] */
    public HttpResponse execute() throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        String userAgent;
        HttpContent httpContent;
        boolean z;
        int i;
        boolean z2;
        StreamingContent streamingContent;
        boolean z3;
        Span span;
        Scope scopeWithSpan;
        Integer numValueOf;
        HttpResponse httpResponse;
        HttpIOExceptionHandler httpIOExceptionHandler;
        HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler;
        boolean zHandleResponse;
        boolean z4;
        BackOffPolicy backOffPolicy;
        long nextBackOffMillis;
        HttpResponseInterceptor httpResponseInterceptor;
        boolean z5;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        String type;
        StreamingContent loggingStreamingContent;
        HttpEncoding httpEncoding;
        String name;
        StreamingContent httpEncodingStreamingContent;
        long length;
        String str;
        String str2;
        HttpRequest httpRequest = this;
        Preconditions.checkArgument(httpRequest.numRetries >= 0);
        int i2 = httpRequest.numRetries;
        BackOffPolicy backOffPolicy2 = httpRequest.backOffPolicy;
        if (backOffPolicy2 != null) {
            backOffPolicy2.reset();
        }
        Preconditions.checkNotNull(httpRequest.requestMethod);
        Preconditions.checkNotNull(httpRequest.url);
        Span spanStartSpan = httpRequest.tracer.spanBuilder(OpenCensusUtils.SPAN_NAME_HTTP_REQUEST_EXECUTE).setRecordEvents(OpenCensusUtils.isRecordEvent()).startSpan();
        int i3 = i2;
        HttpResponse httpResponse2 = null;
        while (true) {
            spanStartSpan.addAnnotation("retry #" + (httpRequest.numRetries - i3));
            if (httpResponse2 != null) {
                httpResponse2.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = httpRequest.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(httpRequest);
            }
            String strBuild = httpRequest.url.build();
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_METHOD, httpRequest.requestMethod);
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_HOST, httpRequest.url.getHost());
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_PATH, httpRequest.url.getRawPath());
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_URL, strBuild);
            LowLevelHttpRequest lowLevelHttpRequestBuildRequest = httpRequest.transport.buildRequest(httpRequest.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z6 = httpRequest.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                try {
                    try {
                        if (z6) {
                            sb = new StringBuilder();
                            sb.append("-------------- REQUEST  --------------").append(StringUtils.LINE_SEPARATOR);
                            sb.append(httpRequest.requestMethod).append(' ').append(strBuild).append(StringUtils.LINE_SEPARATOR);
                            if (httpRequest.curlLoggingEnabled) {
                                sb2 = new StringBuilder("curl -v --compressed");
                                if (!httpRequest.requestMethod.equals("GET")) {
                                    sb2.append(" -X ").append(httpRequest.requestMethod);
                                }
                            }
                            userAgent = httpRequest.headers.getUserAgent();
                            if (!httpRequest.suppressUserAgentSuffix) {
                                if (userAgent == null) {
                                    HttpHeaders httpHeaders = httpRequest.headers;
                                    String str3 = USER_AGENT_SUFFIX;
                                    httpHeaders.setUserAgent(str3);
                                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str3);
                                } else {
                                    String str4 = userAgent + " " + USER_AGENT_SUFFIX;
                                    httpRequest.headers.setUserAgent(str4);
                                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str4);
                                }
                            }
                            OpenCensusUtils.propagateTracingContext(spanStartSpan, httpRequest.headers);
                            HttpHeaders.serializeHeaders(httpRequest.headers, sb, sb2, logger, lowLevelHttpRequestBuildRequest);
                            if (!httpRequest.suppressUserAgentSuffix) {
                                httpRequest.headers.setUserAgent(userAgent);
                            }
                            httpContent = httpRequest.content;
                            if (httpContent != null || httpContent.retrySupported()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (httpContent != null) {
                                type = httpRequest.content.getType();
                                if (z6) {
                                    loggingStreamingContent = new LoggingStreamingContent(httpContent, HttpTransport.LOGGER, Level.CONFIG, httpRequest.contentLoggingLimit);
                                } else {
                                    loggingStreamingContent = httpContent;
                                }
                                httpEncoding = httpRequest.encoding;
                                if (httpEncoding == null) {
                                    length = httpRequest.content.getLength();
                                    name = null;
                                } else {
                                    name = httpEncoding.getName();
                                    httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, httpRequest.encoding);
                                    length = -1;
                                }
                                if (z6) {
                                    if (type != null) {
                                        i = i3;
                                        str2 = "Content-Type: " + type;
                                        z2 = z;
                                        sb.append(str2).append(StringUtils.LINE_SEPARATOR);
                                        if (sb2 != null) {
                                            httpEncodingStreamingContent = loggingStreamingContent;
                                            sb2.append(" -H '" + str2 + "'");
                                        }
                                    } else {
                                        httpEncodingStreamingContent = loggingStreamingContent;
                                        i = i3;
                                        z2 = z;
                                    }
                                    if (name != null) {
                                        str = "Content-Encoding: " + name;
                                        sb.append(str).append(StringUtils.LINE_SEPARATOR);
                                        if (sb2 != null) {
                                            sb2.append(" -H '" + str + "'");
                                        }
                                    }
                                    if (length >= 0) {
                                        sb.append("Content-Length: " + length).append(StringUtils.LINE_SEPARATOR);
                                    }
                                } else {
                                    i = i3;
                                    z2 = z;
                                }
                                if (sb2 != null) {
                                    httpEncodingStreamingContent = loggingStreamingContent;
                                    sb2.append(" -d '@-'");
                                }
                                httpEncodingStreamingContent = loggingStreamingContent;
                                lowLevelHttpRequestBuildRequest.setContentType(type);
                                lowLevelHttpRequestBuildRequest.setContentEncoding(name);
                                lowLevelHttpRequestBuildRequest.setContentLength(length);
                                lowLevelHttpRequestBuildRequest.setStreamingContent(httpEncodingStreamingContent);
                                streamingContent = httpEncodingStreamingContent;
                            } else {
                                spanStartSpan = spanStartSpan;
                                i = i3;
                                z2 = z;
                            }
                            if (z6) {
                                streamingContent = httpContent;
                                logger.config(sb.toString());
                                if (sb2 != null) {
                                    sb2.append(" -- '");
                                    sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                                    sb2.append("'");
                                    if (streamingContent != null) {
                                        sb2.append(" << $$$");
                                    }
                                    logger.config(sb2.toString());
                                }
                            }
                            if (z2 || i <= 0) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            httpRequest = this;
                            lowLevelHttpRequestBuildRequest.setTimeout(httpRequest.connectTimeout, httpRequest.readTimeout);
                            lowLevelHttpRequestBuildRequest.setWriteTimeout(httpRequest.writeTimeout);
                            span = spanStartSpan;
                            scopeWithSpan = httpRequest.tracer.withSpan(span);
                            OpenCensusUtils.recordSentMessageEvent(span, lowLevelHttpRequestBuildRequest.getContentLength());
                            lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
                            if (lowLevelHttpResponseExecute != null) {
                                OpenCensusUtils.recordReceivedMessageEvent(span, lowLevelHttpResponseExecute.getContentLength());
                            }
                            HttpResponse httpResponse3 = new HttpResponse(httpRequest, lowLevelHttpResponseExecute);
                            scopeWithSpan.close();
                            httpResponse = httpResponse3;
                            e = null;
                            numValueOf = null;
                            if (httpResponse == null) {
                                try {
                                    if (httpResponse.isSuccessStatusCode()) {
                                        if (httpResponse == null) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        z4 = z3 & z5;
                                    } else {
                                        httpUnsuccessfulResponseHandler = httpRequest.unsuccessfulResponseHandler;
                                        if (httpUnsuccessfulResponseHandler != null) {
                                            zHandleResponse = httpUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z3);
                                        } else {
                                            zHandleResponse = false;
                                        }
                                        if (!zHandleResponse) {
                                            if (!httpRequest.handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                                                zHandleResponse = true;
                                            } else if (z3 && (backOffPolicy = httpRequest.backOffPolicy) != null && backOffPolicy.isBackOffRequired(httpResponse.getStatusCode())) {
                                                nextBackOffMillis = httpRequest.backOffPolicy.getNextBackOffMillis();
                                                if (nextBackOffMillis != -1) {
                                                    try {
                                                        httpRequest.sleeper.sleep(nextBackOffMillis);
                                                    } catch (InterruptedException unused) {
                                                    }
                                                    zHandleResponse = true;
                                                }
                                            }
                                        }
                                        z4 = z3 & zHandleResponse;
                                        if (z4) {
                                            httpResponse.ignore();
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (httpResponse != null) {
                                        httpResponse.disconnect();
                                    }
                                    throw th;
                                }
                            } else {
                                if (httpResponse == null) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                z4 = z3 & z5;
                            }
                            i3 = i - 1;
                            if (!z4) {
                                if (httpResponse != null) {
                                    numValueOf = Integer.valueOf(httpResponse.getStatusCode());
                                }
                                span.end(OpenCensusUtils.getEndSpanOptions(numValueOf));
                                if (httpResponse != null) {
                                    throw e;
                                }
                                httpResponseInterceptor = httpRequest.responseInterceptor;
                                if (httpResponseInterceptor != null) {
                                    httpResponseInterceptor.interceptResponse(httpResponse);
                                }
                                if (httpRequest.throwExceptionOnExecuteError || httpResponse.isSuccessStatusCode()) {
                                    return httpResponse;
                                }
                                try {
                                    throw new HttpResponseException(httpResponse);
                                } catch (Throwable th2) {
                                    httpResponse.disconnect();
                                    throw th2;
                                }
                            }
                            httpResponse2 = httpResponse;
                            spanStartSpan = span;
                        } else {
                            sb = null;
                        }
                        HttpResponse httpResponse4 = new HttpResponse(httpRequest, lowLevelHttpResponseExecute);
                        scopeWithSpan.close();
                        httpResponse = httpResponse4;
                        e = null;
                        numValueOf = null;
                        if (httpResponse == null) {
                            if (httpResponse == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z4 = z3 & z5;
                        } else if (httpResponse.isSuccessStatusCode()) {
                            httpUnsuccessfulResponseHandler = httpRequest.unsuccessfulResponseHandler;
                            if (httpUnsuccessfulResponseHandler != null) {
                                zHandleResponse = httpUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z3);
                            } else {
                                zHandleResponse = false;
                            }
                            if (!zHandleResponse) {
                                if (!httpRequest.handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                                    zHandleResponse = true;
                                } else if (z3) {
                                    nextBackOffMillis = httpRequest.backOffPolicy.getNextBackOffMillis();
                                    if (nextBackOffMillis != -1) {
                                        httpRequest.sleeper.sleep(nextBackOffMillis);
                                        zHandleResponse = true;
                                    }
                                }
                            }
                            z4 = z3 & zHandleResponse;
                            if (z4) {
                                httpResponse.ignore();
                            }
                        } else {
                            if (httpResponse == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z4 = z3 & z5;
                        }
                        i3 = i - 1;
                        if (!z4) {
                            if (httpResponse != null) {
                                numValueOf = Integer.valueOf(httpResponse.getStatusCode());
                            }
                            span.end(OpenCensusUtils.getEndSpanOptions(numValueOf));
                            if (httpResponse != null) {
                                throw e;
                            }
                            httpResponseInterceptor = httpRequest.responseInterceptor;
                            if (httpResponseInterceptor != null) {
                                httpResponseInterceptor.interceptResponse(httpResponse);
                            }
                            if (httpRequest.throwExceptionOnExecuteError) {
                            }
                            return httpResponse;
                        }
                        httpResponse2 = httpResponse;
                        spanStartSpan = span;
                    } catch (Throwable th3) {
                        InputStream content = lowLevelHttpResponseExecute.getContent();
                        if (content != null) {
                            content.close();
                        }
                        throw th3;
                    }
                    lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
                    if (lowLevelHttpResponseExecute != null) {
                        OpenCensusUtils.recordReceivedMessageEvent(span, lowLevelHttpResponseExecute.getContentLength());
                    }
                } catch (IOException e) {
                    e = e;
                    if (!httpRequest.retryOnExecuteIOException && ((httpIOExceptionHandler = httpRequest.ioExceptionHandler) == null || !httpIOExceptionHandler.handleIOException(httpRequest, z3))) {
                        span.end(OpenCensusUtils.getEndSpanOptions(null));
                        throw e;
                    }
                    numValueOf = null;
                    if (z6) {
                        logger.log(Level.WARNING, "exception thrown while executing request", (Throwable) e);
                    }
                    scopeWithSpan.close();
                    httpResponse = null;
                }
            } catch (Throwable th4) {
                scopeWithSpan.close();
                throw th4;
            }
            sb2 = null;
            userAgent = httpRequest.headers.getUserAgent();
            if (!httpRequest.suppressUserAgentSuffix) {
                if (userAgent == null) {
                    HttpHeaders httpHeaders2 = httpRequest.headers;
                    String str5 = USER_AGENT_SUFFIX;
                    httpHeaders2.setUserAgent(str5);
                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str5);
                } else {
                    String str6 = userAgent + " " + USER_AGENT_SUFFIX;
                    httpRequest.headers.setUserAgent(str6);
                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str6);
                }
            }
            OpenCensusUtils.propagateTracingContext(spanStartSpan, httpRequest.headers);
            HttpHeaders.serializeHeaders(httpRequest.headers, sb, sb2, logger, lowLevelHttpRequestBuildRequest);
            if (!httpRequest.suppressUserAgentSuffix) {
                httpRequest.headers.setUserAgent(userAgent);
            }
            httpContent = httpRequest.content;
            if (httpContent != null) {
                z = true;
            } else {
                z = true;
            }
            if (httpContent != null) {
                type = httpRequest.content.getType();
                if (z6) {
                    loggingStreamingContent = new LoggingStreamingContent(httpContent, HttpTransport.LOGGER, Level.CONFIG, httpRequest.contentLoggingLimit);
                } else {
                    loggingStreamingContent = httpContent;
                }
                httpEncoding = httpRequest.encoding;
                if (httpEncoding == null) {
                    length = httpRequest.content.getLength();
                    name = null;
                } else {
                    name = httpEncoding.getName();
                    httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, httpRequest.encoding);
                    length = -1;
                }
                if (z6) {
                    if (type != null) {
                        i = i3;
                        str2 = "Content-Type: " + type;
                        z2 = z;
                        sb.append(str2).append(StringUtils.LINE_SEPARATOR);
                        if (sb2 != null) {
                            httpEncodingStreamingContent = loggingStreamingContent;
                            sb2.append(" -H '" + str2 + "'");
                        }
                    } else {
                        httpEncodingStreamingContent = loggingStreamingContent;
                        i = i3;
                        z2 = z;
                    }
                    if (name != null) {
                        str = "Content-Encoding: " + name;
                        sb.append(str).append(StringUtils.LINE_SEPARATOR);
                        if (sb2 != null) {
                            sb2.append(" -H '" + str + "'");
                        }
                    }
                    if (length >= 0) {
                        sb.append("Content-Length: " + length).append(StringUtils.LINE_SEPARATOR);
                    }
                } else {
                    i = i3;
                    z2 = z;
                }
                if (sb2 != null) {
                    httpEncodingStreamingContent = loggingStreamingContent;
                    sb2.append(" -d '@-'");
                }
                httpEncodingStreamingContent = loggingStreamingContent;
                lowLevelHttpRequestBuildRequest.setContentType(type);
                lowLevelHttpRequestBuildRequest.setContentEncoding(name);
                lowLevelHttpRequestBuildRequest.setContentLength(length);
                lowLevelHttpRequestBuildRequest.setStreamingContent(httpEncodingStreamingContent);
                streamingContent = httpEncodingStreamingContent;
            } else {
                spanStartSpan = spanStartSpan;
                i = i3;
                z2 = z;
            }
            if (z6) {
                streamingContent = httpContent;
                logger.config(sb.toString());
                if (sb2 != null) {
                    sb2.append(" -- '");
                    sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                    sb2.append("'");
                    if (streamingContent != null) {
                        sb2.append(" << $$$");
                    }
                    logger.config(sb2.toString());
                }
            }
            if (z2) {
                z3 = false;
            } else {
                z3 = false;
            }
            httpRequest = this;
            lowLevelHttpRequestBuildRequest.setTimeout(httpRequest.connectTimeout, httpRequest.readTimeout);
            lowLevelHttpRequestBuildRequest.setWriteTimeout(httpRequest.writeTimeout);
            span = spanStartSpan;
            scopeWithSpan = httpRequest.tracer.withSpan(span);
            OpenCensusUtils.recordSentMessageEvent(span, lowLevelHttpRequestBuildRequest.getContentLength());
        }
    }

    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() { // from class: com.google.api.client.http.HttpRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public HttpResponse call() throws Exception {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newFixedThreadPool(1, new ThreadFactoryBuilder().setDaemon(true).build()));
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location), this.useRawRedirectUrls));
        if (i == 303) {
            setRequestMethod("GET");
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    private static void addSpanAttribute(Span span, String str, String str2) {
        if (str2 != null) {
            span.putAttribute(str, AttributeValue.stringAttributeValue(str2));
        }
    }

    private static String getVersion() {
        String property = "unknown-version";
        try {
            InputStream resourceAsStream = HttpRequest.class.getResourceAsStream("/com/google/api/client/http/google-http-client.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-http-client.version");
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        return property;
    }
}
