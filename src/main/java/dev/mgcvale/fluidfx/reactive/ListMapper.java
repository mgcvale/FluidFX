package dev.mgcvale.fluidfx.reactive;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListMapper {

    public static <S, T> ObservableList<T> map(ObservableList<S> source, Function<S, T> mapper) {
        ObservableList<T> target = FXCollections.observableArrayList();

        for (S item : source)
            target.add(mapper.apply(item));

        source.addListener((ListChangeListener<S>) change -> {
            while (change.next()) {
                if (change.wasPermutated()) {
                    List<T> copy = new ArrayList<>(target.subList(change.getFrom(), change.getTo()));
                    for (int i = change.getFrom(); i < change.getTo(); i++) {
                        int permutedIndex = change.getPermutation(i);
                        target.set(i, copy.get(permutedIndex - change.getFrom()));
                    }
                } else {
                    if (change.wasRemoved()) {
                        target.remove(change.getFrom(), change.getFrom() + change.getRemovedSize());
                    }
                    if (change.wasAdded()) {
                        List<? extends S> added = change.getAddedSubList();
                        for (int i = 0; i < added.size(); i++)
                            target.add(change.getFrom() + i, mapper.apply(added.get(i)));
                    }
                }
            }
        });

        return target;
    }

}
