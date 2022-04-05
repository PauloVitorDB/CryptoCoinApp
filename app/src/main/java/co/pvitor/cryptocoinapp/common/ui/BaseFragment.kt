package co.pvitor.cryptocoinapp.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B: ViewBinding>(
    @LayoutRes private val layoutId: Int,
    private val bind: (View) -> B
): Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = bind(view)

        setupOnViewCreated()
    }

    abstract fun setupOnViewCreated()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}