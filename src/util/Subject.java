package util;

import java.beans.PropertyChangeListener;

public interface Subject {

    void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
    void removePropertyChangeListener(String eventName, PropertyChangeListener listener);
}
