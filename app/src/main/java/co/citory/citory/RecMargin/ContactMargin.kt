package co.citory.citory.RecMargin

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ContactMargin :RecyclerView.ItemDecoration()
{
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
outRect.bottom=19
        outRect.top=19
        outRect.left=19
        outRect.right=19

    }
}