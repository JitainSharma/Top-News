package com.topnews;

import com.topnews.di.ActivityBuildersModule;
import com.topnews.di.AppComponent;
import com.topnews.di.ContextModule;
import com.topnews.di.DBModule;
import com.topnews.di.FragmentBuilderModule;
import com.topnews.di.NetModule;
import com.topnews.di.RepositoryModule;
import com.topnews.di.ViewModelFactoryModule;
import com.topnews.service.repository.NewsRepository;

import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjectionModule;
import it.cosenonjaviste.daggermock.DaggerMockRule;
import it.cosenonjaviste.daggermock.InjectFromComponent;

public class NewsRepositoryTest {

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public DaggerMockRule<AppComponent> mockitoRule =
            new DaggerMockRule<>(AppComponent.class, new RepositoryModule());

//    @Inject
//    ArticleDao mArticleDao;
//
//    @Inject
//    NewsService mNewsService;

    @InjectFromComponent
    NewsRepository newsRepository;

//    @Before
//    public void setUp() {
//        TestComponent component = DaggerTestComponent.builder()
//                .myModule(new DBModuleTest()).build();
//        component.inject(this);
//    }

    @Test
    public void getTopNews_GetData() {

        newsRepository.getTopNews();

    }

}
