``` applescript
# original code

# repeat

# set chargeState to do shell script "pmset -g batt | awk '{printf \"%s %s\\n\", $4,$5;exit}'"

# set percentLeft to do shell script "pmset -g batt | egrep -ow '([0-9]{1,3})[%]' | egrep -ow '[0-9]{1,3}'"

# considering numeric strings

# if chargeState contains "Battery Power" or "AC Power" and percentLeft ≤ 30 then

# display notification "Battery 30% less (REQUIRES CHARGING)" with title "Battery Charge Boundary"

# else if chargeState contains "Battery Power" or "AC Power" and percentLeft ≥ 70 then

# display notification "Battery 70% more (NO CHARGING)" with title "Battery Charge Boundary"

# end if

# end considering

# delay 60

# end repeat

  

  

# custom code

# display starting notification status (once after window start)

**display notification** "Battery Alram is starting." with title "Battery Overseer"

# notification flag with count

**set** lessNoticnt **to** 0

**set** MoreNoticnt **to** 0

# notification process

**repeat**

# get battery charging percent (70%)

**set** percentLeft **to** **do shell script** "pmset -g batt | egrep -ow '([0-9]{1,3})[%]' | egrep -ow '[0-9]{1,3}'"

# get battery charging status (charging / discharging)

**set** chargeState **to** **do shell script** "pmset -g batt | awk '{printf \"%s %s\\n\", $4,$5;exit}'"

**considering** _numeric strings_

# if percentge less than 30% (without charging status)

**if** percentLeft ≤ 30 **and** lessNoticnt ≤ 3 **then**

**set** lessNoticnt **to** (lessNoticnt + 1)

**display notification** "Battery 30% less. (" & lessNoticnt & ")" with title "Battery Charge Boundary"

# if percentge 30% over becuase of charging

**else** **if** percentLeft > 30 **and** chargeState **contains** "charging" **then**

**set** lessNoticnt **to** 0

# if percentge more than 70% (without charging status)

**else** **if** percentLeft ≥ 70 **and** MoreNoticnt ≤ 3 **then**

**set** MoreNoticnt **to** (MoreNoticnt + 1)

**display notification** "Battery 70% more." with title "Battery Charge Boundary"

# if percentge 70% under becuase of uncharging

**else** **if** percentLeft < 70 **and** chargeState **contains** "discharging" **then**

**set** MoreNoticnt **to** 0

**end** **if**

**end** **considering**

**delay** 60

**end** **repeat**
```

