package ru.nlcodeteam.loadingdialogsample;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.TextView;


public class LoadingDialog extends Dialog  {

    private View mDialogView;
    private TextView mContent;
    private AnimationSet mAnimIn, mAnimOut;

    private CharSequence mContentText;
    private boolean mBackPressed;
    private boolean mIsShowAnim;


    public LoadingDialog(Context context) {
        this(context, 0);
    }

    public LoadingDialog(Context context, int theme) {
        super(context, R.style.loading_dialog_style);
        init();
    }

    @Override
    public void onBackPressed() {
        if (mBackPressed)
        super.onBackPressed();
    }

    private void callDismiss() {
        super.dismiss();
    }

    private void init() {
        mAnimIn =
                Util.getInAnimation(getContext());
        mAnimOut = Util.getOutAnimation(getContext());
        initAnimListener();
    }

    @Override
    public void setTitle(CharSequence title) {

    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getContext().getText(titleId));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = View.inflate(getContext(), R.layout.dialog_loading, null);
        setContentView(contentView);
        mDialogView =  getWindow().getDecorView().findViewById(android.R.id.content);
        mContent = (TextView)contentView.findViewById(R.id.dialog_loading_content);
        mContent.setText(mContentText);
        setCanceledOnTouchOutside(false);

    }

    @Override
    protected void onStart() {
        super.onStart();
        startWithAnimation(mIsShowAnim);
    }

    @Override
    public void dismiss() {
        dismissWithAnimation(mIsShowAnim);
    }

    private void startWithAnimation(boolean showInAnimation) {
        if (showInAnimation) {
            mDialogView.startAnimation(mAnimIn);
        }
    }

    private void dismissWithAnimation(boolean showOutAnimation) {
        if (showOutAnimation) {
            mDialogView.startAnimation(mAnimOut);
        } else {
            super.dismiss();
        }
    }

    private void initAnimListener() {
        mAnimOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        callDismiss();
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }






    public LoadingDialog setContentText(CharSequence text) {
        mContentText = text;
        return this;
    }


    public void setBackPressed(boolean backPressed) {
        mBackPressed = backPressed;

    }
}

