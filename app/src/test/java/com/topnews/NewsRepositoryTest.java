package com.topnews;

import com.topnews.service.model.Article;
import com.topnews.service.model.NewsResponse;
import com.topnews.service.repository.NewsRepository;
import com.topnews.service.repository.NewsService;
import com.topnews.service.repository.persistence.ArticleDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

@RunWith(MockitoJUnitRunner.class)
public class NewsRepositoryTest {

    @Mock
    ArticleDao mArticleDao;

    @Mock
    NewsService mNewsService;

    private NewsRepository newsRepository;

    @Before
    public void setUp() {
        newsRepository = new NewsRepository(mArticleDao, mNewsService);
    }

    @Test
    public void getTopNews_GetData_ReturnsTrue() {

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article());
        articles.add(new Article());

        NewsResponse newsResponse = new NewsResponse();
        newsResponse.status = "ok";
        newsResponse.articles = articles;

        Mockito.when(mNewsService.countryTopHeadlines("in", "738baca0278342d9842857e8e0d41980")).thenReturn(Observable.just(newsResponse));
        Mockito.when(mArticleDao.getArticles()).thenReturn(Observable.just(articles));
//        Mockito.when(mArticleDao.insertArticles(articles)).thenReturn(Completable.complete());

        TestObserver<List<Article>> testObserver =
                newsRepository.getTopNews().test();

        //testObserver.awaitTerminalEvent();

        testObserver
                .assertNoErrors()
                .assertValue(articles);

        testObserver.dispose();
    }

}
