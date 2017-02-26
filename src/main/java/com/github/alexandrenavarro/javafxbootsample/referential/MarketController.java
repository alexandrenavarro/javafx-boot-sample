package com.github.alexandrenavarro.javafxbootsample.referential;

import com.github.alexandrenavarro.javafxbootsample.statusbar.BottomStatusBarView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
@Slf4j
public class MarketController {

    private final MarketView marketView;
    private final BottomStatusBarView bottomStatusBarView;

    @Inject
    public MarketController(final MarketView marketView, final BottomStatusBarView bottomStatusBarView) {
        this.marketView = marketView;
        this.bottomStatusBarView = bottomStatusBarView;
    }

    @PostConstruct
    public void initialize() {
        this.marketView.getSearchButtonRef().get().setOnAction(e -> {
            search2();
        });
    }

//    public void search() {
//        this.marketView.getMaskerPaneRef().setVisible(true);
//        final Task<List<Country>> task = new Task<List<Country>>() {
//
//            @Override
//            protected List<Country> call()  {
//                List<Country> countryList;
//                try {
//                    updateProgress(1, 100);
//                    updateMessage("Retrieving Countries ...");
//                    Thread.sleep(1000);
//
//                    countryList = (countryResource.findCountries());
//                    updateMessage("Countries retrieved.");
//                    updateProgress(100, 100);
//
//                } catch (InterruptedException | FeignException e) {
//                    log.warn("e:{}", e);
//                    updateMessage("Error when retrieving countries.");
//                    countryList =  Collections.emptyList();
//                }
//                return countryList;
//            }
//        };
//
//        task.setOnSucceeded(e -> {
//            MarketController.this.marketView.getTableViewRef().setItems(FXCollections.observableArrayList(task.getValue()));
//            this.marketView.getMaskerPaneRef().setVisible(false);
//        });
//
//        this.bottomStatusBarView.getView().progressProperty().bind(task.progressProperty());
//        this.bottomStatusBarView.getView().textProperty().bind(task.messageProperty());
//
//        this.marketView.getMaskerPaneRef().progressProperty().bind(task.progressProperty());
//        this.marketView.getMaskerPaneRef().textProperty().bind(task.messageProperty());
//
//        CompletableFuture.runAsync(() -> task.run());
//        executorService.submit(() -> task.run());
//    }

    public void search2() {
//        final ObservableList<Country> results = FXCollections.observableArrayList();
//        this.marketView.getTableViewRef().setItems(results);
//        final Task<Void> task = new Task<Void>() {
//
//            @Override
//            protected Void call()  {
//                try {
//                    updateMessage("Retrieving Countries ...");
//                    final List<Country> countryList = countryResource.findCountries();
//                    for (int i = 0; i < countryList.size(); i++) {
//                        results.add(countryList.get(i));
//                        Thread.sleep(1);
//                        updateProgress(i, countryList.size() - 1);
//                    }
//                    updateMessage("Countries retrieved.");
//                } catch (InterruptedException | FeignException e) {
//                    log.warn("e:{}", e);
//                    updateMessage("Error when retrieving countries.");
//                }
//                return null;
//            }
//        };
//
//
//        this.bottomStatusBarView.getView().progressProperty().bind(task.progressProperty());
//        this.bottomStatusBarView.getView().textProperty().bind(task.messageProperty());
//
//        CompletableFuture.runAsync(() -> task.run());
    }

}