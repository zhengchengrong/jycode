package com.jy.jyjy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jy.jyjy.api.bean.Student;
import com.jy.jyjy.injector.components.DaggerConstructorComponent;
import com.jy.jyjy.injector.modules.ConstructorModule;

import javax.inject.Inject;
/**
 * Created by zcr on 2017/5/26.
 */
public class TestActivity extends Activity {
    Button btn;
    @Inject
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btn = (Button) findViewById(R.id.btn);
        DaggerConstructorComponent.builder().applicationComponent(AndroidApplication.getAppComponent())
                .constructorModule(new ConstructorModule()).build().inject(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
    }

    private void test() {
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }
}
