package com.hyphenate.easeui.model;

import java.util.Set;

import com.hyphenate.easeui.controller.EaseUI;

import android.content.Context;
import android.content.SharedPreferences;

public class EasePreferenceManager {
    private SharedPreferences.Editor editor;
    private SharedPreferences mSharedPreferences;
    private static final String KEY_AT_GROUPS = "AT_GROUPS"; 
    
    private EasePreferenceManager(){
        if(EaseUI.getInstance().getContext()==null){
            return;
        }
        mSharedPreferences = EaseUI.getInstance().getContext().getSharedPreferences("EM_SP_AT_MESSAGE", Context.MODE_PRIVATE);
        if(mSharedPreferences!=null)
        editor = mSharedPreferences.edit();
    }
    private static EasePreferenceManager instance;
    
    public synchronized static EasePreferenceManager getInstance(){
        if(instance == null){
            instance = new EasePreferenceManager();
        }
        return instance;
        
    }
    
    
    public void setAtMeGroups(Set<String> groups) {
        if(mSharedPreferences==null){
            return ;
        }
        editor.remove(KEY_AT_GROUPS);
        editor.commit();
        editor.putStringSet(KEY_AT_GROUPS, groups);
        editor.commit();
    }
    
    public Set<String> getAtMeGroups(){
        if(mSharedPreferences==null){
            return null;
        }
        return mSharedPreferences.getStringSet(KEY_AT_GROUPS, null);
    }
    
}
