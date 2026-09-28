package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncTaskExecutor<Params, Result> {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f103a;
        public final /* synthetic */ Handler b;

        /* JADX INFO: renamed from: com.adjust.sdk.scheduler.AsyncTaskExecutor$a$a, reason: collision with other inner class name */
        public class RunnableC0004a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f104a;

            public RunnableC0004a(Object obj) {
                this.f104a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                AsyncTaskExecutor.this.onPostExecute(this.f104a);
            }
        }

        public a(Object[] objArr, Handler handler) {
            this.f103a = objArr;
            this.b = handler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public final void run() {
            this.b.post(new RunnableC0004a(AsyncTaskExecutor.this.doInBackground(this.f103a)));
        }
    }

    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(Params... paramsArr) {
        onPreExecute();
        Executors.newSingleThreadExecutor().execute(new a(paramsArr, new Handler(Looper.getMainLooper())));
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
