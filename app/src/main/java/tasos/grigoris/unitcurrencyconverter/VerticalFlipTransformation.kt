package tasos.grigoris.unitcurrencyconverter

import android.support.v4.view.ViewPager
import android.view.View


class VerticalFlipTransformation : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {

        page.translationX = -position * page.getWidth()
        page.cameraDistance = 12000F

        if (position < 0.5 && position > -0.5) {
            page.setVisibility(View.VISIBLE)
        } else {
            page.setVisibility(View.INVISIBLE)
        }



        if (position < -1) {     // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0F)

        } else if (position <= 0) {    // [-1,0]
            page.setAlpha(1F)
            page.setRotationY(180 * (1 - Math.abs(position) + 1))

        } else if (position <= 1) {    // (0,1]
            page.setAlpha(1F)
            page.setRotationY(-180 * (1 - Math.abs(position) + 1))

        } else {    // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0F)

        }


    }
}