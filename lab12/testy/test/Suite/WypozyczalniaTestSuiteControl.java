/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import wypozyczalnia.*;

@RunWith(Categories.class)
@Suite.SuiteClasses({FabrykaTest.class, KlientTest.class, GraTest.class,FasadaTest.class })
@Categories.IncludeCategory(TestControl.class)
public class WypozyczalniaTestSuiteControl {}
