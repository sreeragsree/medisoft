package com.example.medisoft.Authentication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medisoft.BaseActivity;
import com.example.medisoft.R;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class SignupActivity extends BaseActivity {
    BasePDFPagerAdapter adapter;
    RemotePDFViewPager remotePDFViewPager;
    EditText etPdfUrl;
    Button downlod;
    LinearLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        downlod=findViewById(R.id.btn_download);
        root = findViewById(R.id.remote_pdf_root);
        etPdfUrl = findViewById(R.id.et_pdfUrl);
       // setDownloadButtonListener();

    }


}