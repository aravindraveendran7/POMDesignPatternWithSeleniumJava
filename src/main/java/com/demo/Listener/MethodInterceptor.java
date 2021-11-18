package com.demo.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.demo.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance>result=new ArrayList<IMethodInstance>();
		try {
			List<Map<String, String>> list=ExcelUtils.getTestDetails();

			for (int i = 0; i <methods.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestMethodName"))) {
						if(list.get(j).get("ExecutionStatus").equalsIgnoreCase("yes")) {
							methods.get(i).getMethod().setDescription(list.get(j).get("TestCaseDescp"));
							methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(i).get("Count")));
							result.add(methods.get(i));
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
