package com.example.buet.departments;

import com.example.buet.R;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Data {
    private static List<Department> departmentList;
    public static List<Department>getDepartmentList(){
        if(departmentList == null){
            departmentList = new CopyOnWriteArrayList<>();
            createDepartmentList(departmentList);
        }
        return departmentList;
    }
    private static void createDepartmentList(List<Department> departmentList){
        departmentList.add(new Department("Architecture", R.drawable.archi,R.string.arch_url, R.string.arch));
        departmentList.add(new Department("Biomedical Engineering", R.drawable.biomedical, R.string.bme_url, R.string.bme));
        departmentList.add(new Department("Chemical Engineering ", R.drawable.chemical, R.string.che_url, R.string.che));
        departmentList.add(new Department("Civil Engineering", R.drawable.civil, R.string.ce_url, R.string.ce));
        departmentList.add(new Department("Computer Science and Engineering", R.drawable.computer, R.string.cse_url, R.string.cse));
        departmentList.add(new Department("Electrical and Electronic Engineering", R.drawable.electrical, R.string.eee_url, R.string.eee));
        departmentList.add(new Department("Industrial and Production Engineering", R.drawable.industrial, R.string.ipe_url, R.string.ipe));
        departmentList.add(new Department("Materials and Metallurgical Engineering ", R.drawable.material, R.string.mme_url, R.string.mme));
        departmentList.add(new Department("Mechanical Engineering ", R.drawable.mecha, R.string.me_url, R.string.me));
        departmentList.add(new Department("Nanomaterials and Ceramic Engineering", R.drawable.nano, R.string.nce_url, R.string.nce));
        departmentList.add(new Department("Naval Architecture and Marine Engineering ", R.drawable.naval, R.string.name_url, R.string.name));
        departmentList.add(new Department("Urban and Regional Planning", R.drawable.urban, R.string.urp_url, R.string.urp));
        departmentList.add(new Department("Water Resources Engineering ", R.drawable.water, R.string.wre_url, R.string.wre));
    }
}
