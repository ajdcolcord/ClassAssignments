__author__ = 'Austin Colcord'

import sys


# the main method for this program, runs all of the functions to
# calculate and return if the given data set is satisfiable or not
def main():

    # read the lines into the program
    lines = read_in()

    # extract the data, setting variables, constraints, equalities
    # and inequalities as their own pieces of data to be used
    variables, constraints, equalities, inequalities = extract_data(lines)

    # create the graph with the given variables (not connected)
    new_graph = create_graph(variables)

    # add the edges to the existing graph based on the given equalities
    # edges are not added to the inequalities
    add_edges(new_graph, equalities)

    # calculate the connected components of the graph
    connect_comp = new_graph.connected_components()

    # check through the inequalities to see if there exists
    # two items in a connected component that are in the
    # inequalities list
    for tup in inequalities:
        for l in connect_comp:
            if tup[0] in l:
                if tup[1] in l:
                    print("NOT SATISFIABLE")
                    return
                else:
                    break

    print("SATISFIABLE")


# reads in the
def read_in():
    lines = sys.stdin.readlines()
    for i in range(len(lines)):
        lines[i] = lines[i].replace('\n', '')
    return lines


# extract the data from the lines that are given
def extract_data(lines):
    first = lines.pop(0)
    list_first = first.split()
    variables = int(list_first[0])
    constraints = int(list_first[1])

    equalities = []
    inequalities = []

    for s in lines:
        list_s = s.split()
        if list_s[1] == "==":
            equalities.append((int(list_s[0][1:]), int(list_s[2][1:])))
        else:
            inequalities.append((int(list_s[0][1:]), int(list_s[2][1:])))

    return variables, constraints, equalities, inequalities


# create a graph with the given variables (not connected)
def create_graph(variables):
    graph = Graph()
    for x in range(1, variables + 1):
        graph.add_node(Node(x, []))
    return graph


# add edges to the given graph with the given equalities
def add_edges(graph, equalities):
    for edge in equalities:
        id1 = edge[0]
        id2 = edge[1]
        graph.add_node_edges(graph.find_node(id1),
                             graph.find_node(id2))


# setting a global list to keep track of the nodes that
# are visited when calculating the connected components
visited = []


# represents a graph that contains a list of nodes
class Graph:

    # initializing the constructor for this graph class
    def __init__(self):
        self.nodes = []

    # overriding the equals method for this graph class
    def __eq__(self, other):
        if isinstance(other, self.__class__):
            return self.nodes == other.edges
        else:
            return False

    # the string method for this graph
    def __str__(self):
        return str([str(n) for n in self.nodes])

    # adds a new node to the list of nodes in this graph
    def add_node(self, node):
        self.nodes.append(node)

    # tell if the given node is in this list of nodes
    def in_this_graph(self, node):
        in_graph = False
        for n in self.nodes:
            if n.identifier == node.identifier:
                in_graph = True
        return in_graph

    # add the two nodes as an edge to each other
    @staticmethod
    def add_node_edges(node_1, node_2):
        node_1.add_edge(node_2)
        node_2.add_edge(node_1)

    # finds the node in the graph with the given identifier
    def find_node(self, identity):
        return self.nodes[identity - 1]

    # returns the connected components as one list of
    # lists that have nodes that are connected to each other
    def connected_components(self):
        connected_list = []
        for n in self.nodes:
            sys.stdout.flush()
            if n.identifier not in visited:
                dfs_nodes = n.dfs()
                connected_list.append(dfs_nodes)
                visited.extend(dfs_nodes)
        return connected_list


# represents a node that contains an identifier and a list of edges
class Node:

    # initializing the constructor for this node class
    def __init__(self, identifier, edges=[]):
        self.identifier = identifier
        self.edges = edges

    # overriding the equals method for this node class
    def __eq__(self, other):
        if isinstance(other, self.__class__):
            return self.identifier == other.identifier and self.edges == other.edges
        else:
            return False

    # overriding the string method that prints out this node's data (for testing)
    def __str__(self):
        return str(self.identifier) + str([n.identifier for n in self.edges])

    # adds a new node to the edges in this node
    def add_edge(self, other_node):
        self.edges.append(other_node)

    # runs the depth first search algorithm, adding all of the node identifiers
    # that are connected through this node
    def dfs_list(self, seen):
        if self.identifier not in seen:
            seen.append(self.identifier)
            for n in self.edges:
                if n not in seen:
                    seen = n.dfs_list(seen)
        return seen

    # the wrapper class for the accumulator function dfs_list, holding an empty
    # list as the 'seen' field for the function
    def dfs(self):
        return self.dfs_list([])


# run the program
if __name__ == '__main__':
    main()