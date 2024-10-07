# 배터리 충전 제한
---
- .plist
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">  
<plist version="1.0">  
<dict>  
    <key>Label</key>  
    <string>battery-status-monitor.job</string>  
    <key>ProgramArguments</key>  
    <array>  
        <!-- modify your oascript app location -->  
        <string>/usr/bin/osascript</string>  
        <!-- modify your BatteryAlram location -->  
        <string>/Users/mac/Applications/BatteryOverseer/Battery-Overseer.scpt</string>  
    </array>  
    <key>RunAtLoad</key>  
    <true/>  
</dict>  
</plist>
```

- .scpt
``` applescript
# custom code

# display starting notification status (once after window start)

**display notification** "Battery Alram is starting." with title "Battery Overseer"

**delay** 5

  

# notification flag with count

**set** lessNoticnt20 **to** 0

**set** lessNoticnt25 **to** 0

**set** lessNoticnt30 **to** 0

**set** moreNoticnt70 **to** 0

**set** moreNoticnt75 **to** 0

**set** moreNoticnt80 **to** 0

  

# notification process

**repeat**

# get battery charging percent (70%)

**set** percentLeft **to** **do shell script** "pmset -g batt | egrep -ow '([0-9]{1,3})[%]' | egrep -ow '[0-9]{1,3}'"

# Battery gage case algorithm

**considering** _numeric strings_

# Battery Uncharging case (Battery going down is made of 'uncharging status')

# if percentge less than 20%

**if** percentLeft ≤ 20 **and** lessNoticnt20 ≤ 2 **then**

**set** lessNoticnt20 **to** (lessNoticnt20 + 1)

**display notification** "Battery 20% less. (" & lessNoticnt20 & ")" with title "Battery Overseer"

# if percentge less than 25%

**else** **if** percentLeft ≤ 25 **and** lessNoticnt25 ≤ 2 **then**

**set** lessNoticnt25 **to** (lessNoticnt25 + 1)

**display notification** "Battery 25% less. (" & lessNoticnt25 & ")" with title "Battery Overseer"

# if percentge less than 30%

**else** **if** percentLeft ≤ 30 **and** lessNoticnt30 ≤ 2 **then**

**set** lessNoticnt30 **to** (lessNoticnt30 + 1)

**display notification** "Battery 30% less. (" & lessNoticnt30 & ")" with title "Battery Overseer"

# Battery Charging case (Battery going up is made of 'charging status')

# if percentge more than 70%

**else** **if** percentLeft ≥ 70 **and** moreNoticnt70 ≤ 2 **then**

**set** moreNoticnt70 **to** (moreNoticnt70 + 1)

**display notification** "Battery 70% more. (" & moreNoticnt70 & ")" with title "Battery Overseer"

# if percentge more than 75%

**else** **if** percentLeft ≥ 75 **and** moreNoticnt75 ≤ 2 **then**

**set** moreNoticnt75 **to** (moreNoticnt75 + 1)

**display notification** "Battery 75% more. (" & moreNoticnt75 & ")" with title "Battery Overseer"

# if percentge more than 80%

**else** **if** percentLeft ≥ 80 **and** moreNoticnt80 ≤ 2 **then**

**set** moreNoticnt80 **to** (moreNoticnt80 + 1)

**display notification** "Battery 80% more. (" & moreNoticnt80 & ")" with title "Battery Overseer"

# init notification count

**else** **if** 30 < percentLeft **and** percentLeft < 70 **then**

**set** lessNoticnt20 **to** 0

**set** lessNoticnt25 **to** 0

**set** lessNoticnt30 **to** 0

**set** moreNoticnt70 **to** 0

**set** moreNoticnt75 **to** 0

**set** moreNoticnt80 **to** 0

**end** **if**

**end** **considering**

**delay** 10

**end** **repeat**

  

  

# original code

# repeat

# set chargeState to do shell script "pmset -g batt | awk '{printf \"%s %s\\n\", $4,$5;exit}'"

# set percentLeft to do shell script "pmset -g batt | egrep -ow '([0-9]{1,3})[%]' | egrep -ow '[0-9]{1,3}'"

# considering numeric strings

# if chargeState contains "Battery Power" or "AC Power" and percentLeft ≤ 30 then

# display notification "Battery 30% less (REQUIRES CHARGING)" with title "Battery Overseer"

# else if chargeState contains "Battery Power" or "AC Power" and percentLeft ≥ 70 then

# display notification "Battery 70% more (NO CHARGING)" with title "Battery Overseer"

# end if

# end considering

# delay 60

# end repeat
```
> 원본 참고 링크: https://gist.github.com/brandon1024/74b81564aa0b91aa8287faaa175593e6#file-batterystatusnotification-scpt

