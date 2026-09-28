package com.google.games.bridge;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public class HelperFragment extends Fragment {
    private static final String FRAGMENT_TAG = "gpg.HelperFragment";
    static final int RC_RESOLUTION_DIALOG = 9011;
    static final int RC_SELECT_OPPONENTS_UI = 9006;
    static final int RC_SELECT_SNAPSHOT_UI = 9004;
    static final int RC_SHOW_REQUEST_PERMISSIONS_UI = 9010;
    static final int RC_SIGN_IN = 9002;
    static final int RC_SIMPLE_UI = 9003;
    private static final String TAG = "HelperFragment";
    private static HelperFragment helperFragment;
    private static final Object lock = new Object();
    private static Request pendingRequest;
    private static Request runningRequest;

    interface Request {
        void onActivityResult(int i, int i2, Intent intent);

        void process(HelperFragment helperFragment);
    }

    public static Task<Integer> showAchievementUi(Activity activity) {
        AchievementUiRequest achievementUiRequest = new AchievementUiRequest();
        if (!startRequest(activity, achievementUiRequest)) {
            achievementUiRequest.setResult(-12);
        }
        return achievementUiRequest.getTask();
    }

    public static Task<Integer> showAllLeaderboardsUi(Activity activity) {
        AllLeaderboardsUiRequest allLeaderboardsUiRequest = new AllLeaderboardsUiRequest();
        if (!startRequest(activity, allLeaderboardsUiRequest)) {
            allLeaderboardsUiRequest.setResult(-12);
        }
        return allLeaderboardsUiRequest.getTask();
    }

    public static Task<Integer> showLeaderboardUi(Activity activity, String str, int i) {
        LeaderboardUiRequest leaderboardUiRequest = new LeaderboardUiRequest(str, i);
        if (!startRequest(activity, leaderboardUiRequest)) {
            leaderboardUiRequest.setResult(-12);
        }
        return leaderboardUiRequest.getTask();
    }

    public static Task<SelectSnapshotUiRequest.Result> showSelectSnapshotUi(Activity activity, String str, boolean z, boolean z2, int i) {
        SelectSnapshotUiRequest selectSnapshotUiRequest = new SelectSnapshotUiRequest(str, z, z2, i);
        if (!startRequest(activity, selectSnapshotUiRequest)) {
            selectSnapshotUiRequest.setResult(-5);
        }
        return selectSnapshotUiRequest.getTask();
    }

    public static boolean isResolutionRequired(Exception exc) {
        return exc instanceof ResolvableApiException;
    }

    public static Task<Integer> askForLoadFriendsResolution(Activity activity, PendingIntent pendingIntent) {
        GenericResolutionUiRequest genericResolutionUiRequest = new GenericResolutionUiRequest(pendingIntent);
        if (!startRequest(activity, genericResolutionUiRequest)) {
            genericResolutionUiRequest.setResult(-12);
        }
        return genericResolutionUiRequest.getTask();
    }

    public static Task<Integer> showCompareProfileWithAlternativeNameHintsUI(Activity activity, String str, String str2, String str3) {
        CompareProfileUiRequest compareProfileUiRequest = new CompareProfileUiRequest(str, str2, str3);
        if (!startRequest(activity, compareProfileUiRequest)) {
            compareProfileUiRequest.setResult(-12);
        }
        return compareProfileUiRequest.getTask();
    }

    private static boolean startRequest(Activity activity, Request request) {
        boolean z;
        synchronized (lock) {
            if (pendingRequest == null && runningRequest == null) {
                pendingRequest = request;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            HelperFragment helperFragment2 = getHelperFragment(activity);
            if (helperFragment2.isResumed()) {
                helperFragment2.processRequest();
            }
        }
        return z;
    }

    private static HelperFragment getHelperFragment(Activity activity) {
        HelperFragment helperFragment2 = (HelperFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (helperFragment2 != null) {
            return helperFragment2;
        }
        try {
            Log.d(TAG, "Creating fragment");
            HelperFragment helperFragment3 = new HelperFragment();
            FragmentTransaction fragmentTransactionBeginTransaction = activity.getFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(helperFragment3, FRAGMENT_TAG);
            fragmentTransactionBeginTransaction.commit();
            return helperFragment3;
        } catch (Throwable th) {
            Log.e(TAG, "Cannot launch token fragment:" + th.getMessage(), th);
            return null;
        }
    }

    private void processRequest() {
        synchronized (lock) {
            if (runningRequest != null) {
                return;
            }
            Request request = pendingRequest;
            pendingRequest = null;
            runningRequest = request;
            if (request == null) {
                return;
            }
            request.process(this);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Request request;
        super.onActivityResult(i, i2, intent);
        synchronized (lock) {
            request = runningRequest;
        }
        if (request == null) {
            return;
        }
        request.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Fragment
    public void onResume() {
        Log.d(TAG, "onResume called");
        super.onResume();
        if (helperFragment == null) {
            helperFragment = this;
        }
        processRequest();
    }

    static void finishRequest(Request request) {
        synchronized (lock) {
            if (runningRequest == request) {
                runningRequest = null;
            }
        }
    }

    public static View createInvisibleView(Activity activity) {
        View view = new View(activity);
        view.setVisibility(4);
        view.setClickable(false);
        return view;
    }

    public static View getDecorView(Activity activity) {
        return activity.getWindow().getDecorView();
    }
}
