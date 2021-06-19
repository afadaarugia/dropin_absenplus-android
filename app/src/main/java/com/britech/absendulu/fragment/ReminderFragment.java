package com.britech.absendulu.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.britech.absendulu.R;
import com.britech.absendulu.remainder.SMSMessageReceiver;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReminderFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {

    private SMSMessageReceiver releaseTodayReceiver = new SMSMessageReceiver();
    private String dailyReminder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        dailyReminder = getString(R.string.id_daily_reminder);

        SwitchPreference switchDailyReminder = (SwitchPreference) findPreference(dailyReminder);
        switchDailyReminder.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String id = preference.getKey();
        boolean thisSet = (boolean) newValue;

        if (id.equals(dailyReminder)){
            if (thisSet) {
                releaseTodayReceiver.setReleaseToday(getActivity());
                Toast.makeText(getActivity(), "Active", Toast.LENGTH_SHORT).show();
            } else {
                releaseTodayReceiver.setCencel(getActivity());
                Toast.makeText(getActivity(), "Off", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }
}
