package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.DownloadModule;
import com.jy.jyjy.module.manage.download.DownloadActivity;

import dagger.Component;

/**
 * Created by long on 2016/12/19.
 * video下载 Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = DownloadModule.class)
public interface DownloadComponent {
    void inject(DownloadActivity activity);
}
