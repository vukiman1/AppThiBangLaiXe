// Generated by view binder compiler. Do not edit!
package com.example.thibanglaixe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.thibanglaixe.R;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final ImageView buttonHelp;

  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final Toolbar menuDrawer;

  @NonNull
  public final RelativeLayout navBar;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rcvTopics;

  private ActivityMainBinding(@NonNull DrawerLayout rootView, @NonNull ImageView buttonHelp,
      @NonNull ConstraintLayout container, @NonNull DrawerLayout drawerLayout,
      @NonNull Toolbar menuDrawer, @NonNull RelativeLayout navBar, @NonNull NavigationView navView,
      @NonNull ProgressBar progressbar, @NonNull RecyclerView rcvTopics) {
    this.rootView = rootView;
    this.buttonHelp = buttonHelp;
    this.container = container;
    this.drawerLayout = drawerLayout;
    this.menuDrawer = menuDrawer;
    this.navBar = navBar;
    this.navView = navView;
    this.progressbar = progressbar;
    this.rcvTopics = rcvTopics;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonHelp;
      ImageView buttonHelp = ViewBindings.findChildViewById(rootView, id);
      if (buttonHelp == null) {
        break missingId;
      }

      id = R.id.container;
      ConstraintLayout container = ViewBindings.findChildViewById(rootView, id);
      if (container == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.menuDrawer;
      Toolbar menuDrawer = ViewBindings.findChildViewById(rootView, id);
      if (menuDrawer == null) {
        break missingId;
      }

      id = R.id.navBar;
      RelativeLayout navBar = ViewBindings.findChildViewById(rootView, id);
      if (navBar == null) {
        break missingId;
      }

      id = R.id.navView;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rcvTopics;
      RecyclerView rcvTopics = ViewBindings.findChildViewById(rootView, id);
      if (rcvTopics == null) {
        break missingId;
      }

      return new ActivityMainBinding((DrawerLayout) rootView, buttonHelp, container, drawerLayout,
          menuDrawer, navBar, navView, progressbar, rcvTopics);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
