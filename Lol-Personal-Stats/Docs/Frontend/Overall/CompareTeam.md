# Compare Stats 

This [file](../../../frontend/src/Overall/comps/CompareTeam.js) just a compent that will create a [card](../Common.md) and create a similar list of fitlers such as [Compare](./CompareStats.md) but this one when you press the button it will create two insitances of [CompareT](#CompareT) and pass the information from the fields to these components

## ComapreT

The CompareT Compenent allows to filter a second time on the list of records that you already filter from the Compare Stats that created the CompareT components. 

It has a similar list of filters as Compare Stats but also has a Team/Enemy Filter to filter to only your team or enemy however for this to work it requires only one player be listed in the Compare Stats Player field.

The purpose of this is to allow you to do something such as when player x plays Varus Mid in Draft/Solo Duo/Flex are the Yasuos' that are on the enemy team playing better then the Yasuos' on this team.  