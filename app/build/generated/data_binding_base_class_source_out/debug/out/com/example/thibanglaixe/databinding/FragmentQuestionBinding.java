// Generated by view binder compiler. Do not edit!
package com.example.thibanglaixe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.thibanglaixe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentQuestionBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final LinearLayout explain;

  @NonNull
  public final ImageView imageQuestion;

  @NonNull
  public final RecyclerView rcvAnswer;

  @NonNull
  public final TextView textExplainDetails;

  @NonNull
  public final TextView textQuestion;

  @NonNull
  public final TextView textQuestionMark;

  private FragmentQuestionBinding(@NonNull ScrollView rootView, @NonNull LinearLayout explain,
      @NonNull ImageView imageQuestion, @NonNull RecyclerView rcvAnswer,
      @NonNull TextView textExplainDetails, @NonNull TextView textQuestion,
      @NonNull TextView textQuestionMark) {
    this.rootView = rootView;
    this.explain = explain;
    this.imageQuestion = imageQuestion;
    this.rcvAnswer = rcvAnswer;
    this.textExplainDetails = textExplainDetails;
    this.textQuestion = textQuestion;
    this.textQuestionMark = textQuestionMark;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentQuestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentQuestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_question, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentQuestionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.explain;
      LinearLayout explain = ViewBindings.findChildViewById(rootView, id);
      if (explain == null) {
        break missingId;
      }

      id = R.id.imageQuestion;
      ImageView imageQuestion = ViewBindings.findChildViewById(rootView, id);
      if (imageQuestion == null) {
        break missingId;
      }

      id = R.id.rcvAnswer;
      RecyclerView rcvAnswer = ViewBindings.findChildViewById(rootView, id);
      if (rcvAnswer == null) {
        break missingId;
      }

      id = R.id.textExplainDetails;
      TextView textExplainDetails = ViewBindings.findChildViewById(rootView, id);
      if (textExplainDetails == null) {
        break missingId;
      }

      id = R.id.textQuestion;
      TextView textQuestion = ViewBindings.findChildViewById(rootView, id);
      if (textQuestion == null) {
        break missingId;
      }

      id = R.id.textQuestionMark;
      TextView textQuestionMark = ViewBindings.findChildViewById(rootView, id);
      if (textQuestionMark == null) {
        break missingId;
      }

      return new FragmentQuestionBinding((ScrollView) rootView, explain, imageQuestion, rcvAnswer,
          textExplainDetails, textQuestion, textQuestionMark);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
