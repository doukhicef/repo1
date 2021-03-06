package com.example.pci.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class frag extends Fragment {

    WebView page;
    int numpage;

    public static frag newInstance(int pagenum) {
        frag mapage = new frag();

        Bundle args = new Bundle();
        args.putInt("pagenum", pagenum);
        mapage.setArguments(args);

        return mapage;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.numpage = getArguments().getInt("pagenum", 0);

        return inflater.inflate(R.layout.frag, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        page = (WebView) view.findViewById(R.id.page);
        page.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });

        page.loadUrl("file:///android_asset/page"+String.valueOf(numpage)+".html");
        page.requestFocus();
    }
}