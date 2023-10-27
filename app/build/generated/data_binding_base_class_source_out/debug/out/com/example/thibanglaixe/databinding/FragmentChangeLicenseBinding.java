// Generated by view binder compiler. Do not edit!
package com.example.thibanglaixe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.thibanglaixe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChangeLicenseBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cardA1;

  @NonNull
  public final CardView cardA2;

  @NonNull
  public final ImageView icA1;

  @NonNull
  public final ImageView icA2;

  @NonNull
  public final ImageView imageCheckA1;

  @NonNull
  public final ImageView imageCheckA2;

  @NonNull
  public final Toolbar toolbarBack;

  private FragmentChangeLicenseBinding(@NonNull LinearLayout rootView, @NonNull CardView cardA1,
      @NonNull CardView cardA2, @NonNull ImageView icA1, @NonNull ImageView icA2,
      @NonNull ImageView imageCheckA1, @NonNull ImageView imageCheckA2,
      @NonNull Toolbar toolbarBack) {
    this.rootView = rootView;
    this.cardA1 = cardA1;
    this.cardA2 = cardA2;
    this.icA1 = icA1;
    this.icA2 = icA2;
    this.imageCheckA1 = imageCheckA1;
    this.imageCheckA2 = imageCheckA2;
    this.toolbarBack = toolbarBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChangeLicenseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChangeLicenseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_change_license, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChangeLicenseBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_a1;
      CardView cardA1 = ViewBindings.findChildViewById(rootView, id);
      if (cardA1 == null) {
        break missingId;
      }

      id = R.id.card_a2;
      CardView cardA2 = ViewBindings.findChildViewById(rootView, id);
      if (cardA2 == null) {
        break missingId;
      }

      id = R.id.ic_a1;
      ImageView icA1 = ViewBindings.findChildViewById(rootView, id);
      if (icA1 == null) {
        break missingId;
      }

      id = R.id.ic_a2;
      ImageView icA2 = ViewBindings.findChildViewById(rootView, id);
      if (icA2 == null) {
        break missingId;
      }

      id = R.id.image_check_a1;
      ImageView imageCheckA1 = ViewBindings.findChildViewById(rootView, id);
      if (imageCheckA1 == null) {
        break missingId;
      }

      id = R.id.image_check_a2;
      ImageView imageCheckA2 = ViewBindings.findChildViewById(rootView, id);
      if (imageCheckA2 == null) {
        break missingId;
      }

      id = R.id.toolbarBack;
      Toolbar toolbarBack = ViewBindings.findChildViewById(rootView, id);
      if (toolbarBack == null) {
        break missingId;
      }

      return new FragmentChangeLicenseBinding((LinearLayout) rootView, cardA1, cardA2, icA1, icA2,
          imageCheckA1, imageCheckA2, toolbarBack);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
