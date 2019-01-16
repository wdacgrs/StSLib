package com.evacipated.cardcrawl.mod.stslib.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BlindnessPower extends AbstractPower {
  public static final String POWER_ID = "stslib:Blindness";
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
  public static final String NAME = BlindnessPower.powerStrings.NAME;
  public static final String[] DESCRIPTIONS = BlindnessPower.powerStrings.DESCRIPTIONS;

  public BlindnessPower(AbstractCreature owner) {
    name = BlindnessPower.NAME;
    ID = POWER_ID;
    this.owner = owner;
    this.type = PowerType.DEBUFF;
    this.updateDescription();
    img = ImageMaster.loadImage("images/stslib/powers/32/blindness.png");
  }

  @Override
  public void updateDescription() {
    description = BlindnessPower.DESCRIPTIONS[0];
  }
}