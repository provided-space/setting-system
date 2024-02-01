package space.provided.setting;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SettingManager {

    private static final SettingManager INSTANCE;

    private final List<Setting<?>> settings;

    static {
        INSTANCE = new SettingManager();
    }

    public SettingManager() {
        settings = new LinkedList<>();
    }

    public void add(Setting<?> setting) {
        settings.add(setting);
    }

    public List<Setting<?>> getSettings() {
        return settings;
    }

    public List<Setting<?>> getSettingsByParent(SettingParent settingParent) {
        return settings.stream().filter(setting -> setting.getSettingParent() != null &&
                setting.getSettingParent().equals(settingParent)).collect(Collectors.toList());
    }

    public static SettingManager getInstance() {
        return INSTANCE;
    }
}
