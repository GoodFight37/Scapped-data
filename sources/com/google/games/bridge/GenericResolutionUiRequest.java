package com.google.games.bridge;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
class GenericResolutionUiRequest implements HelperFragment.Request {
    static final int SELECT_UI_STATUS_INTERNAL_ERROR = -2;
    static final int SELECT_UI_STATUS_RESULT_OK = 1;
    static final int SELECT_UI_STATUS_USER_CLOSED_UI = -6;
    private static final String TAG = "FriendsSharingConsent";
    private final PendingIntent pendingIntent;
    private final TaskCompletionSource<Integer> resultTaskSource = new TaskCompletionSource<>();

    GenericResolutionUiRequest(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    Task<Integer> getTask() {
        return this.resultTaskSource.getTask();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(HelperFragment helperFragment) {
        Intent intent = new Intent(helperFragment.getActivity(), (Class<?>) GenericResolutionActivity.class);
        intent.putExtra("RequestFriendsAccessPermissionPendingIntent", this.pendingIntent);
        helperFragment.startActivityForResult(intent, 9011);
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9011) {
            if (i2 == -1) {
                setResult(1);
            } else if (i2 == 0) {
                setResult(-6);
            } else {
                Log.d(TAG, "onActivityResult unknown resultCode: " + i2);
                setResult(-2);
            }
        }
    }

    void setResult(Integer num) {
        this.resultTaskSource.setResult(num);
        HelperFragment.finishRequest(this);
    }

    void setFailure(Exception exc) {
        this.resultTaskSource.setException(exc);
        HelperFragment.finishRequest(this);
    }
}
