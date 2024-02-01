package space.provided.setting;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Setting<T> {

    private final String name;

    private final String displayName;
    private final List<SettingFilter> filters;

    private SettingParent settingParent;
    private Consumer<T> onValueChange;

    protected T value;

    public Setting(String name, String displayName, SettingParent settingParent) {
        this.name = "setting." + settingParent.getId() + "." + name;
        this.displayName = displayName;
        this.settingParent = settingParent;
        this.filters = new LinkedList<>();

        SettingManager.getInstance().getSettings().add(this);
    }

    public void setValue(T value) {
        this.value = value;

        onChange(value);
    }

    private void onChange(T value) {
        if (onValueChange == null) {
            return;
        }

        onValueChange.accept(value);
    }

    public void addFilter(SettingFilter settingFilter) {
        filters.add(settingFilter);
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setOnValueChange(Consumer<T> onValueChange) {
        this.onValueChange = onValueChange;
    }

    public void setSettingParent(SettingParent settingParent) {
        this.settingParent = settingParent;
    }

    public boolean isFiltered() {
        return filters.stream().allMatch(SettingFilter::get);
    }

    public List<SettingFilter> getFilters() {
        return filters;
    }

    public SettingParent getSettingParent() {
        return settingParent;
    }

    public Consumer<T> getOnValueChange() {
        return onValueChange;
    }

    public T getValue() {
        return value;
    }
}