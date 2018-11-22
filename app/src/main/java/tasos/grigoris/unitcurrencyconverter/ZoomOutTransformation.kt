package tasos.grigoris.unitcurrencyconverter

import android.support.v4.view.ViewCompat.setAlpha
import android.support.v4.view.ViewCompat.setScaleY
import android.support.v4.view.ViewCompat.setScaleX
import android.support.v4.view.ViewPager
import android.view.View


class ZoomOutTransformation : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {

        if (position < -1) {  // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.alpha = 0F

        } else if (position <= 1) { // [-1,1]

            page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
            page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
            page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))

        } else {  // (1,+Infinity]
            // This page is way off-screen to the right.
            page.alpha = 0F

        }


    }

    companion object {

        private val MIN_SCALE = 0.65f
        private val MIN_ALPHA = 0.3f
    }
}