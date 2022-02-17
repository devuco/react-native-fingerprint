package com.reactnativefingerprint;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ReactModule(name = FingerprintModule.NAME)
public class FingerprintModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Fingerprint";

    public FingerprintModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }
    
    // Example method
    // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void useFingerPrint(String title, String subtitle, String description, boolean usePassword, Callback cb) {
    new Handler(Looper.getMainLooper()).post(() -> {
      BiometricPrompt biometricPrompt;
      BiometricPrompt.PromptInfo promptInfo;
      FragmentActivity fragmentActivity= (FragmentActivity) getCurrentActivity();
      Executor executor = Executors.newSingleThreadExecutor();
      biometricPrompt = new BiometricPrompt(fragmentActivity,executor, new BiometricPrompt.AuthenticationCallback() {
        @Override
        public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
          super.onAuthenticationError(errorCode, errString);
          cb.invoke(null,errString);
        }

        @Override
        public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
          super.onAuthenticationSucceeded(result);
          cb.invoke(true,null);
        }

        @Override
        public void onAuthenticationFailed() {
          super.onAuthenticationFailed();
          cb.invoke(false,null);
        }
      });
      String cancel="";
      if(!usePassword) {
        cancel="cancel";
      }
      promptInfo = new BiometricPrompt.PromptInfo.Builder()
        .setTitle(title)
        .setSubtitle(subtitle)
        .setDescription(description)
        .setNegativeButtonText(cancel)
        .setDeviceCredentialAllowed(usePassword)
        .build();

      biometricPrompt.authenticate(promptInfo);
    });

  }

    public static native int nativeMultiply(int a, int b);
}
