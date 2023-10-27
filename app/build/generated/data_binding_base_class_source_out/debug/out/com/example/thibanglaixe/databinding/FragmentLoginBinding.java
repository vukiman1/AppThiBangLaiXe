// Generated by view binder compiler. Do not edit!
package com.example.thibanglaixe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.thibanglaixe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonLogin;

  @NonNull
  public final CheckBox checkboxShowPassword;

  @NonNull
  public final EditText editPassword;

  @NonNull
  public final EditText editUsername;

  @NonNull
  public final TextView textForget;

  @NonNull
  public final TextView textLogin;

  @NonNull
  public final TextView textSignUp;

  @NonNull
  public final Toolbar toolbarBack;

  private FragmentLoginBinding(@NonNull RelativeLayout rootView, @NonNull Button buttonLogin,
      @NonNull CheckBox checkboxShowPassword, @NonNull EditText editPassword,
      @NonNull EditText editUsername, @NonNull TextView textForget, @NonNull TextView textLogin,
      @NonNull TextView textSignUp, @NonNull Toolbar toolbarBack) {
    this.rootView = rootView;
    this.buttonLogin = buttonLogin;
    this.checkboxShowPassword = checkboxShowPassword;
    this.editPassword = editPassword;
    this.editUsername = editUsername;
    this.textForget = textForget;
    this.textLogin = textLogin;
    this.textSignUp = textSignUp;
    this.toolbarBack = toolbarBack;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonLogin;
      Button buttonLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonLogin == null) {
        break missingId;
      }

      id = R.id.checkboxShowPassword;
      CheckBox checkboxShowPassword = ViewBindings.findChildViewById(rootView, id);
      if (checkboxShowPassword == null) {
        break missingId;
      }

      id = R.id.editPassword;
      EditText editPassword = ViewBindings.findChildViewById(rootView, id);
      if (editPassword == null) {
        break missingId;
      }

      id = R.id.editUsername;
      EditText editUsername = ViewBindings.findChildViewById(rootView, id);
      if (editUsername == null) {
        break missingId;
      }

      id = R.id.textForget;
      TextView textForget = ViewBindings.findChildViewById(rootView, id);
      if (textForget == null) {
        break missingId;
      }

      id = R.id.textLogin;
      TextView textLogin = ViewBindings.findChildViewById(rootView, id);
      if (textLogin == null) {
        break missingId;
      }

      id = R.id.textSignUp;
      TextView textSignUp = ViewBindings.findChildViewById(rootView, id);
      if (textSignUp == null) {
        break missingId;
      }

      id = R.id.toolbarBack;
      Toolbar toolbarBack = ViewBindings.findChildViewById(rootView, id);
      if (toolbarBack == null) {
        break missingId;
      }

      return new FragmentLoginBinding((RelativeLayout) rootView, buttonLogin, checkboxShowPassword,
          editPassword, editUsername, textForget, textLogin, textSignUp, toolbarBack);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
