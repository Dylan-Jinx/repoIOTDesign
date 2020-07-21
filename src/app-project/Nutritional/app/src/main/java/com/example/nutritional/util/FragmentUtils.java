package com.example.nutritional.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * @author 69182
 */
public class FragmentUtils {
    public static void ReplaceFragment(FragmentManager manager, int id, Fragment fragment) {
        manager.beginTransaction()
                .replace(id, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}
