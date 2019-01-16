package com.evacipated.cardcrawl.mod.stslib.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(clz = AbstractMonster.class, method = "renderTip")
@SpirePatch(clz = AbstractMonster.class, method = "render")
public class BlindnessPatch {
    public static ExprEditor Instrument() {
        return new ExprEditor() {
            boolean first = true;

            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                if (m.getMethodName().equals("hasRelic") && first) {
                    first = false;
                    m.replace(
                            "{ $_ = ($proceed($$) || com.megacrit.cardcrawl.dungeons.AbstractDungeon.player.hasPower(stslib.powers.BlindnessPower.POWER_ID)); }");
                }
            }
        };
    }
}