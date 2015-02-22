UNAMUNO
=======


Data is plentiful but alas, it is complicated. For the Canadian Open Data Experience 2015 Hackathon our team, Data Existentialists, seeks to free the data from most this complexity, focusing on the subset of the available information relevant to the user's stated goals, in the current location of the user. This is why we have build Unamuno, an Android app with "Data for the Here and Now".

How it works
------------

We have curated a subset of the datasets available and incorporate them into the App, for off-line use. Using these datasets, we have identified a number of user profiles. When the app starts, the current location is retrieved a from GPS location services and the information from the datasets is shown for the profile chosen by the user. Other profiles can be enabled by swiping in the screen.

Under the hood
--------------

Our app is completely generic. It is a platform from presenting aggregated location and task specific information. The different profiles are defined in a JSON file provided with the app (which could be updated from a centralized server, if need be).

The presentation of the datasets is also configurable. In the time available we defined only one data widget but more can be enabled also through a JSON file.

All the data employed by Unamuno is shipped with the app as an embedded SQLite3 database. This allows using Unamuno without Internet access, a plus for consulting data while being on the field.

The future
----------

We managed to incorporate only a few datasets in the time available for the hackathon. Moreover, the datasets we incorporated are at the city level. We plan to expand the datasets with finer granularity crossing other sources, like Open Street Maps.

An area we interested in expanding Unamuno is in speech output, enabling a "as you drive" mode where the relevant datasets are described as location changes.
