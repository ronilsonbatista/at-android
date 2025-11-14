package com.example.notas;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final NotasFragment notasFragment = new NotasFragment();
    private final ArquivadasFragment arquivadasFragment = new ArquivadasFragment();

    public ViewPagerAdapter(@NonNull FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return notasFragment;
        } else {
            return arquivadasFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public NotasFragment getNotasFragment() {
        return notasFragment;
    }
}
