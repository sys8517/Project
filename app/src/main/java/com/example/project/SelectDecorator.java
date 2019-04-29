package com.example.project;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

public class SelectDecorator implements DayViewDecorator {

    private CalendarDay day;
    private HashSet<CalendarDay> dates;
    private int color;

    public SelectDecorator(int color, TabFragment3 context) {
        this.color = color;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day != null && day.equals(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.4f));
        view.addSpan(new DotSpan(5, color)); // 날자밑에 점

    }
}
