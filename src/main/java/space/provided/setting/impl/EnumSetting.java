package space.provided.setting.impl;

import space.provided.setting.DescribableSetting;
import space.provided.setting.ResettableSetting;
import space.provided.setting.SettingParent;

public class EnumSetting<T extends Enum<T>> extends DescribableSetting<T> implements ResettableSetting {

    private final Class<T> klass;
    private final T[] modes;
    private final T defaultValue;

    public EnumSetting(String name, String displayName, T defaultValue, SettingParent settingParent, String description) {
        super(name, displayName, settingParent, description);

        this.klass = defaultValue.getDeclaringClass();
        this.modes = klass.getEnumConstants();
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    public T[] getModes() {
        return modes;
    }

    @Override
    public void reset() {
        setValue(defaultValue);
    }

    public Class<T> getKlass() {
        return klass;
    }

}
