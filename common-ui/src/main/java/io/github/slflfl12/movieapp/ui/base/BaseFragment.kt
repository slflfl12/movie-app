package io.github.slflfl12.movieapp.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.databinding.library.baseAdapters.BR
import io.github.slflfl12.presentation.base.BaseViewModel

abstract class BaseFragment<B: ViewDataBinding, VM: BaseViewModel>(@LayoutRes private val layoutResId: Int) : Fragment() {

    protected lateinit var binding: B

    abstract val vm: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.setVariable(BR.vm, vm)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onDestroy() {
        vm.unbindViewModel()
        super.onDestroy()
    }


    fun showKeyboard() {
        (activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
                InputMethodManager.SHOW_FORCED,0
        )
    }

    fun hideKeyboard() {
        (activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                (activity?.currentFocus ?: View(requireContext())).windowToken, 0
        )
    }

}