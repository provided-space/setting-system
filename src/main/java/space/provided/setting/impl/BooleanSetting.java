package space.provided.setting.impl;

import space.provided.setting.DescribableSetting;
import space.provided.setting.ResettableSetting;
import space.provided.setting.SettingParent;

public class BooleanSetting extends DescribableSetting<Boolean> implements ResettableSetting {

    private final boolean defaultValue;

    public BooleanSetting(String name, String displayName, Boolean defaultValue, SettingParent settingParent, String description) {
        super(name, displayName, settingParent, description);

        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void reset() {
        setValue(defaultValue);
    }
}
