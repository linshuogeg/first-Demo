package com.example.usercenterq.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
/*
/Fragment的适配器
 */
class FragmentAdapter(fm:FragmentManager,private val list: List<Fragment>,private val list1: List<String>):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
       return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list1[position]
    }
}