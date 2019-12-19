package nyc.ignitelabs.civicduty

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock



fun testLifecycleOwner(): LifecycleOwner {
    val owner: LifecycleOwner = mock(LifecycleOwner::class.java)
    val lifecycle = LifecycleRegistry(owner)
    lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    `when`(owner.lifecycle).thenReturn(lifecycle)
    return owner
}
