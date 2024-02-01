package space.provided.setting.impl;

import space.provided.setting.Setting;
import space.provided.setting.SettingParent;

public class LabelSetting extends Setting<Setting<?>[]> implements SettingParent {

    private final String label;

    public LabelSetting(String name, String displayName, SettingParent settingParent) {
        super(name, displayName, settingParent);

        this.label = name;
    }

    @Override
    public void setValue(Setting<?>[] value) {
        for (Setting<?> setting : value) {
            setting.setSettingParent(this);
        }
        super.setValue(value);
    }

    @Override
    public String getId() {
        return "category." + label;
    }
}
