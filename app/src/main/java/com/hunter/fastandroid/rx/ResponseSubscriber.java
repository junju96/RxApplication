package com.hunter.fastandroid.rx;

import android.content.DialogInterface;

import com.hunter.fastandroid.base.IBaseView;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Subscriber;


/**
 * RxJava 自定义Subscriber
 *
 * @param <T>
 * @author Hunter
 */
public abstract class ResponseSubscriber<T> implements Subscriber<T> {
    private static final String TAG = "ResponseSubscriber";
    private IBaseView mBaseView;

    public ResponseSubscriber(IBaseView baseView) {
        mBaseView = baseView;
        mBaseView.setProgressCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
            }
        });

    }

    @Override
    public void onError(Throwable e) {
        mBaseView.hideProgress();
        Logger.e(TAG, e.getMessage());
    }
}
