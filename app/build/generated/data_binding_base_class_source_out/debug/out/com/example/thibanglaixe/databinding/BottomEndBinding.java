// Generated by view binder compiler. Do not edit!
package com.example.thibanglaixe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.thibanglaixe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomEndBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonAgree;

  @NonNull
  public final Button buttonCancel;

  private BottomEndBinding(@NonNull LinearLayout rootView, @NonNull Button buttonAgree,
      @NonNull Button buttonCancel) {
    this.rootView = rootView;
    this.buttonAgree = buttonAgree;
    this.buttonCancel = buttonCancel;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomEndBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomEndBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_end, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomEndBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_agree;
      Button buttonAgree = ViewBindings.findChildViewById(rootView, id);
      if (buttonAgree == null) {
        break missingId;
      }

      id = R.id.button_cancel;
      Button buttonCancel = ViewBindings.findChildViewById(rootView, id);
      if (buttonCancel == null) {
        break missingId;
      }

      return new BottomEndBinding((LinearLayout) rootView, buttonAgree, buttonCancel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
