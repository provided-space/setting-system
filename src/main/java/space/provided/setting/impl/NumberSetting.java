package space.provided.setting.impl;

import space.provided.setting.DescribableSetting;
import space.provided.setting.ResettableSetting;
import space.provided.setting.SettingParent;

public class NumberSetting extends DescribableSetting<Float> implements ResettableSetting {

    private final float min;
    private final float max;

    private final float accuracy;
    private final float defaultValue;
    private final String suffix;

    public NumberSetting(String name, String displayName, Float defaultValue, float min, float max, float accuracy, String suffix, SettingParent settingParent, String description) {
        super(name, displayName, settingParent, description);

        this.min = min;
        this.max = max;
        this.accuracy = accuracy;
        this.suffix = suffix;

        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setValue(Float value) {
        final float factor = 1f / accuracy;
        final float rounded = Math.round(Math.max(min, Math.min(max, value)) * factor) / factor;
        super.setValue(rounded);
    }

    @Override
    public void reset() {
        setValue(defaultValue);
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public String getSuffix() {
        return suffix;
    }
}
