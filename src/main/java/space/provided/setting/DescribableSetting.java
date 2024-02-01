package space.provided.setting;

public class DescribableSetting<T> extends Setting<T> {

    private final String description;

    public DescribableSetting(String name, String displayName, SettingParent settingParent, String description) {
        super(name, displayName, settingParent);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
