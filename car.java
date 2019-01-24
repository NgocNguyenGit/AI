package net.sourceforge.jFuzzyLogic.test;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class TestTipper {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "car.fcl";
        FIS fis = FIS.load(fileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" 
                                   + fileName + "'");
            return;
        }

        // Show 
        fis.chart();

        // Set inputs
        fis.setVariable("distance", 300);
        fis.setVariable("speed", 100);

        // Evaluate
        fis.evaluate();

        //system's output
        fis.getVariable("distance").getLatestDefuzzifiedValue();
        fis.getVariable("speed").getLatestDefuzzifiedValue();

        // Show output variable's chart 
        fis.getVariable("change speed").chartDefuzzifier(true);

        // Print ruleSet
        System.out.println(fis);
    }
}