package it.giobalda.notesapp.utils.ui

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * Custom init
 * - no blur animations | using (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
 * - item with fixed size
 * - set adapter
 */
fun RecyclerView.init(
    adapter: RecyclerView.Adapter<*>,
    itemFixedSize: Boolean = true,
    isHorizontal: Boolean = false,
    withStaggeredLayout: Boolean = false,
    sharedViewPool: RecyclerView.RecycledViewPool? = null,
    spanCount: Int = 1
) {
    this.adapter = adapter
    setHasFixedSize(itemFixedSize)

    val orientation =
        if (isHorizontal) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL

    sharedViewPool?.let {
        setRecycledViewPool(sharedViewPool)
    }

    layoutManager =
        if (withStaggeredLayout) StaggeredGridLayoutManager(spanCount, orientation)
        else GridLayoutManager(this.context, spanCount, orientation, false)
}
