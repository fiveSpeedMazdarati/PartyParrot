<html>
<head>
    <link rel="shortcut icon" type="image/icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
<title>Party Parrot 4 Ever</title>
</head>
<body>
<div class="container">
    <div class="container-fluid">
    <div class="fixed-top">
        <img src="parrotbanner.jpg" alt="banner" style="width: 100%">
    </div>
    </div>
</div>
<div class="container tm">

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#top">
                        Party Parrot 4 Ever
                    </a>
                </li>
                <li>
                    <a href="https://cultofthepartyparrot.com" target="_blank">
                        Party Parrots Website
                    </a>
                </li>
                <li>
                    <a href="#name">Find By Name</a>
                </li>
                <li>
                    <a href="#category">Find By Category</a>
                </li>
                <li>
                    <a href="#categories">Get List of Categories</a>
                </li>
                <li>
                    <a href="#all">Get All Parrots</a>
                </li>
                <li>
                    <a href="#add">Add A Parrot</a>
                </li>
                <li>
                    <a href="/JavaDoc" target="_blank">Documentation</a>
                </li>
                <li>
                    <a href="#donate">Donate</a>
                </li>

            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
<%--
                <div class="row">

--%>
                <span class="trick" id="top"></span>
                    <div class="col-md-12">
                        <h4 class=text-center">The Preeminent Party Parrot API on the ENTIRE internets!</h4>

                    </div>
                <br/><br/>
                <h4>Method URLs</h4>
    <p>Base: <a href="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots">http://52.14.41.110:8080/PartyParrot4Ever/services/parrots</a></p>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="pr-3">Verb</th>
                        <th>Method</th>
                        <th>Endpoint</th>
                        <th>Description</th>
                    </thead>
                    <tr>
                        <td class="text-info">GET</td>
                        <td>Get Parrot by entering Parrot's name
                        </td>
                        <td>/parrots/(parrot name)
                        </td>
                        <td>Accepts name as input and returns attributes for the matched parrot
                        </td>
                    </tr>
                    <tr>
                        <td class="text-info">GET</td>
                        <td>Get Parrots by entering Parrot category
                        </td>
                        <td>/categories/(category name)
                        </td>
                        <td>Accepts a category and returns all parrots data in that category
                        </td>
                    </tr>

                    <tr>
                        <td class="text-info">GET</td>
                        <td>Get List of Parrot Categories
                        </td>
                        <td>/categories
                        </td>
                        <td>Returns all categories Party Parrots may fall into
                        </td>
                    </tr>

                    <tr>
                        <td class="text-info">GET</td>
                        <td class="mr-2">Get All the Parrots
                        </td>
                        <td>(the base url will take you there!)
                        </td>
                        <td>Returns all Parrots ... because why not?
                        </td>
                    </tr>

                    <tr>
                        <td class="text-primary">POST</td>
                        <td>Add a Parrot
                        </td>
                        <td>/new-parrots/(name)/(link)/(hd link)/(category)
                        </td>
                        <td>Contributes to the ever-growing Party Parrot enterprise
                        </td>
                    </tr>


                </table>
                <span class="trick" id="name"></span>
                <section class="mt-5">
                    <h3>Get Parrot By Name</h3>
                    <p>Example Request: <a href="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/Aussie Parrot">http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/Aussie Parrot</a><small class="pl-2">(Spaces are okay!! We handle that)</small></p>
                    <div class="card">
                        <div class="card-body">
                            <code> <br/>
                                <span class="pl-2"> {</span>
                                    <br/>
                                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/aussieparrot.gif"</a>,</span><br/>
                                <span class="pl-4">"name": "Aussie Parrot",</span><br/>
                                <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif"</a>,</span><br/>
                                    <span class="pl-4">"category": "traditional"</span><br/>
                                    <span class="pl-2">}<br/></span>
                                </code>
                        </div>
                    </div>
                </section>
    <span class="trick" id="category"></span>
    <section class="mt-5">
        <h3>Get Parrot By Category</h3>
        <p>Example Request: <a href="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/categories/technology">http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/categories/technology</a></p>
        <div class="card">
            <div class="card-body">
                <code> <br/>
                    [<br/>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"name": "Open-source Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": null, </span><br/>
                    <span class="pl-4">"name": "Github Party Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/githubparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/githubparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-2"> {</span><br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/upvoteparrot.gif">"https://cultofthepartyparrot.com/parrots/upvoteparrot.gif",</a></span><br/>
                    <span class="pl-4">"name": "Upvote Parrot",</span><br/>
                    <span class="pl-4">"hd": null,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">}<br/></span>
                ]
                </code>
            </div>
        </div>
    </section>
    <span class="trick" id="categories"></span>
    <section class="mt-5">
        <h3>Get Possible Parrot Categories</h3>
        <p>Request: <a href="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/categories">http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/categories</a></p>
        <div class="card">
            <div class="card-body">
                <code> <br/>
                    [<br/>
                    <span class="pl-4">"traditional",</span><br/>
                    <span class="pl-4">"technology",</span><br/>
                     <span class="pl-4">"hip",</span><br/>
                     <span class="pl-4">"food",</span><br/>
                     <span class="pl-4">"holiday",</span><br/>
                     <span class="pl-4">"steve",</span><br/>
                     <span class="pl-4">"bernardo"</span><br/>
                     ]
                </code>
            </div>
        </div>
    </section>

    <span class="trick" id="all"></span>
    <section class="mt-5">
        <h3>Get All Parrots!</h3>
        <p>Request: <a href="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots">/parrots</a></p>
        <div class="card">
            <div class="card-body">
                <code> <br/>
                    [<br/>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/parrot.gif">"https://cultofthepartyparrot.com/parrots/parrot.gif",</a></span><br/>
                    <span class="pl-4">"name": "Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/parrot.gif">"https://cultofthepartyparrot.com/parrots/hd/parrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "traditional"</span><br/>
                    <span class="pl-2">},<br/></span>

                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"name": "Open-source Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/middleparrot.gif">"https://cultofthepartyparrot.com/parrots/middleparrot.gif",</a>,</span><br/>
                    <span class="pl-4">"name": "Middle Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/middleparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/middleparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "traditional"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/aussieparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"name": "Aussie Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "traditional"</span><br/>
                    <span class="pl-2">}<br/></span>
                    ] </code> <br/>+ 140 more and counting!!

            </div>
        </div>
    </section>
              <%--  </div>--%>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
        <span class="trick" id="add"></span>
        <section class="mt-5">
            <h3>Add a Parrot!</h3>

            <p>Use this handy form! (or Postman if you hate easy things)</p>
            <div class="card text-white bg-dark col-sm-6 mt-3">
            <div class="card-body">
            <form enctype="application/x-www-form-urlencoded" action="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/parrots/" method="POST">
            <div class="form-group">
                <label class="mr-4">Name:&nbsp; </label><input name="name"/><br />
            </div>
            <div class="form-group">
                <label class="mr-3">Link:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name="link"><br />
            </div>
            <div class="form-group">
                <label class="mr-3">HD Link:</label><input name="hdLink"><br />
            </div>
            <div class="form-group">
                <label class="mr-2">Category:</label><input name="category"><br />
            </div>
                <span class="float-right">
                <input type="submit" value="Add Parrot" class="btn btn-info">
                </span>
            </form>
            </div>
        </div>

        </section>
<br/><br/>
        <span class="trick" id="donate"></span>
        <section class="mt-5">

            <h3>Donate to keep the Parrots Partying!</h3>
            <br/>
           <a href="https://www.doc.govt.nz/kakapo-recovery">Donate Here</a>
        <br/>
        </section>
<br/><br/>
    <!-- /#wrapper -->
<footer class="col-sm-6 offset-3">&copy;2019 Party Parrot 4 Ever - Heidi, Luke, Kelly</footer
    <br/><br/>
</div>
</div>
</body>

</html>
