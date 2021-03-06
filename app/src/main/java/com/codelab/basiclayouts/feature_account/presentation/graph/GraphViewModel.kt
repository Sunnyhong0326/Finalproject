package com.codelab.basiclayouts.feature_account.presentation.graph

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelab.basiclayouts.core.domain.use_case.AccountingUseCases
import com.codelab.basiclayouts.feature_account.presentation.search_filter.components.HexToJetpackColor
import com.codelab.basiclayouts.feature_account.domain.model.AccountTypeTotalData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GraphViewModel @Inject constructor(
    private val accountingUseCases: AccountingUseCases
) : ViewModel(){
    private val _incomeTypePercentageData = getIncomeData().toMutableStateList()
    val incomeTypePercentageData: List<AccountTypeTotalData>
        get() = _incomeTypePercentageData

    private val _incomeMoneyData = getIncomeMoney().toMutableStateList()
    val incomeMoneyData: List<Float>
        get() = _incomeMoneyData

    private val _expenseTypePercentageData = getExpenseData().toMutableStateList()
    val expenseTypePercentageData: List<AccountTypeTotalData>
        get() = _expenseTypePercentageData

    private val _expenseMoneyData = getExpenseMoney().toMutableStateList()
    val expenseMoneyData: List<Float>
        get() = _expenseMoneyData

    private var _graphInterval by mutableStateOf(setGraphInterval("Year"))

    val graphInterval: String
        get() = _graphInterval

    private fun getIncomeMoney(): List<Float> {
        val tmpList = mutableListOf<Float>()

        for(i in 0..(_incomeTypePercentageData.size-1)){
            tmpList.add(_incomeTypePercentageData[i].money.toFloat())
        }

        return tmpList.toList()
    }

    private fun getExpenseMoney(): List<Float> {
        val tmpList = mutableListOf<Float>()

        for(i in 0..(_expenseTypePercentageData.size-1)){
            tmpList.add(_expenseTypePercentageData[i].money.toFloat())
        }

        return tmpList.toList()
    }

    // ?????????function???????????? toggle button?????????graph???????????????????????????????????????
    // return ??????????????? Year Month Day
    fun setGraphInterval(interval: String): String{

        return interval
    }

}

private fun getIncomeData(): List<AccountTypeTotalData> {
    return listOf(
        AccountTypeTotalData("??????", 0.3f, HexToJetpackColor.getColor("FF9898"), 300),
        AccountTypeTotalData("??????", 0.2f, HexToJetpackColor.getColor("5388D8"), 200),
        AccountTypeTotalData("??????", 0.15f, HexToJetpackColor.getColor("F4BE37"), 150),
        AccountTypeTotalData("??????", 0.15f, HexToJetpackColor.getColor("FAA73C"), 150),
        AccountTypeTotalData("??????", 0.1f, HexToJetpackColor.getColor("FF9040"), 100),
        AccountTypeTotalData("??????", 0.1f, HexToJetpackColor.getColor("00AF54"), 100),
    )
}

private fun getExpenseData(): List<AccountTypeTotalData> {
    return listOf(
        AccountTypeTotalData("??????", 0.3f, HexToJetpackColor.getColor("7A96EB"), 300),
        AccountTypeTotalData("??????", 0.2f, HexToJetpackColor.getColor("B9E2FC"), 200),
        AccountTypeTotalData("??????", 0.15f, HexToJetpackColor.getColor("F9DA8B"), 150),
        AccountTypeTotalData("??????", 0.15f, HexToJetpackColor.getColor("6CD534"), 150),
        AccountTypeTotalData("??????", 0.1f, HexToJetpackColor.getColor("79EA7A"), 100),
        AccountTypeTotalData("??????", 0.1f, HexToJetpackColor.getColor("85FFC0"), 100),
    )
}
