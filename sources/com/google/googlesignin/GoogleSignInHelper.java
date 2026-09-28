package com.google.googlesignin;

import android.app.Activity;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleSignInHelper {
    static final String TAG = "GoogleSignInHelper";
    private static CancellationSignal cancellationSignal = null;
    public static boolean loggingEnabled = false;
    private static Supplier<Task<AuthorizationResult>> signInFunction;
    private static Task<AuthorizationResult> task;

    public static void enableDebugLogging(boolean z) {
        loggingEnabled = z;
    }

    public static boolean isPending() {
        Task<AuthorizationResult> task2 = task;
        return (task2 == null || task2.isComplete() || task.isCanceled()) ? false : true;
    }

    public static int getStatus() {
        if (signInFunction == null) {
            return 10;
        }
        Task<AuthorizationResult> task2 = task;
        if (task2 == null) {
            return 4;
        }
        if (task2.isCanceled()) {
            return 16;
        }
        if (task.isSuccessful()) {
            return 0;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return 13;
        }
        logError("onFailure with INTERNAL_ERROR : " + exception.getClass().toString() + " " + exception.getMessage());
        return 8;
    }

    public static void configure(final Activity activity, final String str, final boolean z, final String[] strArr, final IListener iListener) {
        logDebug("TokenFragment.configure called");
        signInFunction = new Supplier<Task<AuthorizationResult>>() { // from class: com.google.googlesignin.GoogleSignInHelper.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public Task<AuthorizationResult> get() {
                if (GoogleSignInHelper.isPending()) {
                    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                    taskCompletionSource.trySetException(new Exception("Last task still pending"));
                    return taskCompletionSource.getTask();
                }
                GoogleSignInHelper.cancellationSignal = new CancellationSignal();
                GetCredentialRequest.Builder preferImmediatelyAvailableCredentials = new GetCredentialRequest.Builder().setPreferImmediatelyAvailableCredentials(false);
                preferImmediatelyAvailableCredentials.addCredentialOption(new GetSignInWithGoogleOption.Builder(str).build());
                final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
                final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource(cancellationTokenSource.getToken());
                CredentialManager.create(activity).getCredentialAsync(activity, preferImmediatelyAvailableCredentials.build(), GoogleSignInHelper.cancellationSignal, TaskExecutors.MAIN_THREAD, new CredentialManagerCallback<GetCredentialResponse, GetCredentialException>() { // from class: com.google.googlesignin.GoogleSignInHelper.1.1
                    @Override // androidx.credentials.CredentialManagerCallback
                    public void onResult(GetCredentialResponse getCredentialResponse) {
                        taskCompletionSource2.trySetResult(getCredentialResponse);
                    }

                    @Override // androidx.credentials.CredentialManagerCallback
                    public void onError(GetCredentialException getCredentialException) {
                        if (getCredentialException instanceof GetCredentialCancellationException) {
                            GoogleSignInHelper.logInfo("Sign-in cancelled by user.");
                            cancellationTokenSource.cancel();
                        } else {
                            taskCompletionSource2.trySetException(getCredentialException);
                        }
                    }
                });
                return taskCompletionSource2.getTask().onSuccessTask(new SuccessContinuation<GetCredentialResponse, AuthorizationResult>() { // from class: com.google.googlesignin.GoogleSignInHelper.1.4
                    @Override // com.google.android.gms.tasks.SuccessContinuation
                    public Task<AuthorizationResult> then(GetCredentialResponse getCredentialResponse) throws Exception {
                        Credential credential = getCredentialResponse.getCredential();
                        Log.i(GoogleSignInHelper.TAG, "credential.getType() : " + credential.getType());
                        iListener.onAuthenticated(GoogleIdTokenCredential.createFrom(credential.getData()).getZzb());
                        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder();
                        int length = strArr != null ? strArr.length : 0;
                        ArrayList arrayList = new ArrayList(length + 2);
                        arrayList.add(new Scope(Scopes.PROFILE));
                        if (z) {
                            arrayList.add(new Scope("email"));
                        }
                        if (length > 0) {
                            for (String str2 : strArr) {
                                arrayList.add(new Scope(str2));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            builder.setRequestedScopes(arrayList);
                        }
                        return Identity.getAuthorizationClient(activity).authorize(builder.build());
                    }
                }).addOnFailureListener(iListener).addOnCanceledListener(iListener).addOnSuccessListener(new OnSuccessListener<AuthorizationResult>() { // from class: com.google.googlesignin.GoogleSignInHelper.1.3
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(AuthorizationResult authorizationResult) {
                        iListener.onAuthorized(authorizationResult);
                    }
                }).addOnCompleteListener(new OnCompleteListener<AuthorizationResult>() { // from class: com.google.googlesignin.GoogleSignInHelper.1.2
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public void onComplete(Task<AuthorizationResult> task2) {
                        GoogleSignInHelper.cancellationSignal = null;
                    }
                });
            }
        };
    }

    public static Task<AuthorizationResult> signIn() {
        Task<AuthorizationResult> task2 = signInFunction.get();
        task = task2;
        return task2;
    }

    public static void cancel() {
        CancellationSignal cancellationSignal2;
        if (isPending() && (cancellationSignal2 = cancellationSignal) != null) {
            cancellationSignal2.cancel();
            cancellationSignal = null;
        }
        task = null;
    }

    public static void signOut(Activity activity) {
        cancel();
        CredentialManager.create(activity).clearCredentialStateAsync(new ClearCredentialStateRequest(), new CancellationSignal(), TaskExecutors.MAIN_THREAD, new CredentialManagerCallback<Void, ClearCredentialException>() { // from class: com.google.googlesignin.GoogleSignInHelper.2
            @Override // androidx.credentials.CredentialManagerCallback
            public void onResult(Void r1) {
                GoogleSignInHelper.logInfo("signOut");
            }

            @Override // androidx.credentials.CredentialManagerCallback
            public void onError(ClearCredentialException clearCredentialException) {
                GoogleSignInHelper.logError(clearCredentialException.getMessage());
            }
        });
    }

    public static void logInfo(String str) {
        if (loggingEnabled) {
            Log.i(TAG, str);
        }
    }

    public static void logError(String str) {
        Log.e(TAG, str);
    }

    public static void logDebug(String str) {
        if (loggingEnabled) {
            Log.d(TAG, str);
        }
    }
}
